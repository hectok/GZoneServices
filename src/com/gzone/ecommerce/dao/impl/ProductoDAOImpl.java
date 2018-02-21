/**
 * 
 */
package com.gzone.ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.dao.ProductoDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Categoria;
import com.gzone.ecommerce.model.Idioma;
import com.gzone.ecommerce.model.NJugadores;
import com.gzone.ecommerce.model.Producto;
import com.gzone.ecommerce.service.ProductoCriteria;

/**
 * @author hector.ledo.doval
 *
 */
public class ProductoDAOImpl implements ProductoDAO{
	
	private static Logger logger = LogManager.getLogger(ProductoDAOImpl.class.getName());

	public ProductoDAOImpl() {
	}
	

	/*
	 * Método para comprobar si un Producto existe
	 * 
	 */
	@Override
	public Boolean exists(Connection connection, Long id) 
			throws DataException {
		boolean exist = false;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = 
					"SELECT p.nombre, p.precio , p.anio , p.requisitos , p.id_oferta " + 
							"FROM Producto p " +
							"WHERE p.id_producto = ? ";

			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				exist = true;
			}

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}

		return exist;
	}

	/*
	 * Método para contar el número total de Productos.
	 * 
	 */
	@Override
	public long countAll(Connection connection) 
			throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = 
					" SELECT count(*) "
							+ " FROM Producto";

			preparedStatement = connection.prepareStatement(queryString);

						resultSet = preparedStatement.executeQuery();

			int i=1;
			if (resultSet.next()) {
				return resultSet.getLong(i++);
			} else {
				throw new DataException("Unexpected condition trying to retrieve count value");
			}

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}	    	 
	}
	
	@Override
	public Producto findById(Connection connection, Long id, String idioma) 
			throws InstanceNotFoundException, DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {          

			String queryString = 
					" SELECT p.id_producto, p.nombre, p.precio, p.anio, p.requisitos, p.id_oferta, pi.detalles_largo, pi.detalles_corto " + 
					" FROM Producto p " +
					" INNER JOIN Producto_Idioma pi ON p.id_producto = pi.id_producto "+
					" WHERE p.id_producto = ? AND pi.id_idioma = ? ";

			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setLong(i++, id);
			preparedStatement.setString(i++, idioma);


			// Execute query      
			System.out.println(preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();

			Producto e = null;

			if (resultSet.next()) {
				e = loadNext(connection, resultSet);				
			} else {
				throw new InstanceNotFoundException("Products with id " + id + 
						"not found", Producto.class.getName());
			}
			return e;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {            
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}  
	}
	
	/*
	 * Método de búsqueda por criteria.
	 * 
	 */
	@Override
	public List<Producto> findByCriteria(Connection connection, ProductoCriteria producto, int startIndex, int count, String idioma)
			throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuilder queryString = null;

		try {
			queryString = new StringBuilder(
					" SELECT p.id_producto, p.nombre, p.precio, p.anio, p.requisitos, p.id_oferta, pi.detalles_largo, pi.detalles_corto " + 
					" FROM Producto p " +
					" INNER JOIN Producto_Idioma pi ON p.id_producto = pi.id_producto " );
			
			// Marca (flag) de primera clausula, que se desactiva en la primera
			boolean first = true;
			
			if (!producto.getCategorias().isEmpty()) {
				queryString.append("INNER JOIN producto_categoria pc ON p.id_producto = pc.id_producto INNER JOIN categoria c ON c.id_categoria=pc.id_categoria ");	
			}

			if (!producto.getNjugadores().isEmpty()) {
				queryString.append("INNER JOIN Producto_NJugadores pn ON p.id_producto = pn.id_producto INNER JOIN NJugadores n ON pn.id_njugador=n.id_nJugadores ");	
			}

			if (!producto.getIdioma().isEmpty()) {
				queryString.append("INNER JOIN Producto_Idioma_Disponible pid ON p.id_producto = pid.id_producto INNER JOIN Idioma i ON pid.id_idioma = i.id_idioma ");	
			}

			if (producto.getIdProducto()!=null) {
				addClause(queryString, first, " p.id_producto LIKE ? ");
				first = false;
			}
			
			if (producto.getNombre()!=null) {
				addClause(queryString, first, " p.nombre LIKE ? ");
				first = false;
			}
			
			if (producto.getPrecio()!=null) {
				addClause(queryString, first, " p.precio LIKE ? ");
				first = false;
			}

			if (producto.getAnio()!=null) {
				addClause(queryString, first, " p.anio LIKE ? ");
				first = false;
			}			
			
			if (producto.getRequisitos()!=null) {
				addClause(queryString, first, " p.requisitos LIKE ? ");
				first = false;
			}	
			
			if (producto.getOferta()!=null) {
				addClause(queryString, first, " p.id_oferta LIKE ? ");
				first = false;
			}
			
			if (idioma!=null) {
				addClause(queryString, first, " pi.id_idioma LIKE ? ");
				first = false;
			}

			if (!producto.getCategorias().isEmpty()) {
				addClause(queryString, first,addCategoria(producto.getCategorias()).toString());	
				first = false;
			}
			
			if (!producto.getNjugadores().isEmpty()) {
				addClause(queryString, first,addNJugadores(producto.getNjugadores()).toString());	
				first = false;
			}
			
			if (!producto.getIdioma().isEmpty()) {
				addClause(queryString, first,addIdioma(producto.getIdioma()).toString());	
				first = false;
			}
		
			preparedStatement = connection.prepareStatement(queryString.toString(),
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;       
			
			if (producto.getIdProducto()!=null) 
				preparedStatement.setString(i++, "%" + producto.getIdProducto() + "%");
			if (producto.getNombre()!=null) 
				preparedStatement.setString(i++, "%" + producto.getNombre() + "%");
			if (producto.getPrecio()!=null) 
				preparedStatement.setString(i++, "%" + producto.getPrecio() + "%");
			if (producto.getAnio()!=null)
				preparedStatement.setString(i++, "%" + producto.getAnio() + "%");
			if (producto.getRequisitos()!=null) 
				preparedStatement.setString(i++, "%" + producto.getRequisitos() + "%");
			if (producto.getOferta()!=null) 
				preparedStatement.setString(i++, "%" + producto.getOferta() + "%");
			if (idioma!=null) 
				preparedStatement.setString(i++,idioma);
			
			resultSet = preparedStatement.executeQuery();
			
			List<Producto> results = new ArrayList<Producto>();                        
			Producto e = null;
			int currentCount = 0;

			if ((startIndex >=1) && resultSet.absolute(startIndex)) {
				do {
					e = loadNext(connection, resultSet);
					results.add(e);               	
					currentCount++;                	
				} while ((currentCount < count) && resultSet.next()) ;
			}

			return results;
	
			} catch (SQLException e) {
				logger.error("Error",e);
				throw new DataException(e);
			} finally {
				JDBCUtils.closeResultSet(resultSet);
				JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
	@Override
	public List<Producto> findAll(Connection connection, int startIndex, int count, String idioma) 
					throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			// Create "preparedStatement"       
			String queryString = 
					"SELECT p.id_producto, p.nombre, p.precio, p.anio, p.requisitos, p.id_oferta, pi.detalles_largo, pi.detalles_corto " + 
					"FROM Producto p  " +
					"INNER JOIN Producto_Idioma pi ON p.id_producto = pi.id_producto " +
					"WHERE pi.id_idioma = ? " +
					"ORDER BY p.nombre asc ";

			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;
			preparedStatement.setString(i++, idioma);
			
			// Execute query.
			resultSet = preparedStatement.executeQuery();

			// Recupera la pagina de resultados
			List<Producto> results = new ArrayList<Producto>();                        
			Producto e = null;
			int currentCount = 0;

			if ((startIndex >=1) && resultSet.absolute(startIndex)) {
				do {
					e = loadNext(connection,resultSet);
					results.add(e);               	
					currentCount++;                	
				} while ((currentCount < count) && resultSet.next()) ;
			}

			return results;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}
	}

	@Override
	public Producto create(Connection connection, Producto p) 
			throws DuplicateInstanceException, DataException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {          

			// Creamos el preparedstatement
			String queryString = "INSERT INTO Producto(nombre,precio,anio,requisitos,id_oferta ) "
					+ "VALUES (?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(queryString,
									Statement.RETURN_GENERATED_KEYS);

			// Fill the "preparedStatement"
			int i = 1;             
			preparedStatement.setString(i++, p.getNombre());
			preparedStatement.setDouble(i++, p.getPrecio());
			preparedStatement.setLong(i++, p.getAnio());
			preparedStatement.setString(i++, p.getRequisitos());
			
			if (p.getOferta()!=null)
					preparedStatement.setLong(i++, p.getOferta());
			else
				preparedStatement.setNull(i++,java.sql.Types.NULL);

			// Execute query
			int insertedRows = preparedStatement.executeUpdate();

			if (insertedRows == 0) {
				throw new SQLException("Can not add row to table 'Producto'");
			}
						
			// Recuperamos la PK generada
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				Long id = resultSet.getLong(1); 
				p.setIdProducto(id);
			} else {
				throw new DataException("Unable to fetch autogenerated primary key");
			}

			// Return the DTO
			return p;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}
	}

	@Override
	public void update(Connection connection, Producto producto) 
			throws InstanceNotFoundException, DataException {
		
		PreparedStatement preparedStatement = null;
		StringBuilder queryString = null;
		try {	
			
			queryString = new StringBuilder(
					" UPDATE Producto" 
					);
			
			boolean first = true;
			
			if (producto.getNombre()!=null) {
				addUpdate(queryString, first, " nombre = ? ");
				first = false;
			}
			
			if (producto.getPrecio()!=null) {
				addUpdate(queryString, first, " precio = ? ");
				first = false;
			}
			
			if (producto.getAnio()!=null) {
				addUpdate(queryString, first, " anio = ? ");
				first = false;
			}
			
			if (producto.getRequisitos()!=null) {
				addUpdate(queryString, first, " requisitos = ? ");
				first = false;
			}
			
			if (producto.getOferta()!=0) {
				addUpdate(queryString, first, " id_oferta = ? ");
				first = false;
			}
			
			queryString.append("WHERE id_producto = ?");
			
			preparedStatement = connection.prepareStatement(queryString.toString());
			

			int i = 1;
			if (producto.getNombre()!=null) 
				preparedStatement.setString(i++,producto.getNombre());
			
			if (producto.getPrecio()!=null) 
				preparedStatement.setDouble(i++,producto.getPrecio());
			
			if (producto.getAnio()!=null) 
				preparedStatement.setInt(i++,producto.getAnio());
			
			if (producto.getRequisitos()!=null) 
				preparedStatement.setString(i++,producto.getRequisitos());
			
			if (producto.getOferta()!=0) 
				preparedStatement.setLong(i++,producto.getOferta());
			

			preparedStatement.setLong(i++, producto.getIdProducto());

			int updatedRows = preparedStatement.executeUpdate();

			if (updatedRows == 0) {
				throw new InstanceNotFoundException(producto.getIdProducto(), Producto.class.getName());
			}

			if (updatedRows > 1) {
				throw new SQLException("Duplicate row for id = '" + 
						producto.getIdProducto() + "' in table 'Producto'");
			}     
			
		} catch (SQLException e) {
			throw new DataException(e);    
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}              		
	}

	@Override
	public long delete(Connection connection, Long id) 
			throws InstanceNotFoundException, DataException {
		PreparedStatement preparedStatement = null;

		try {
			String queryString =	
					  "DELETE FROM Producto " 
					+ "WHERE id_producto = ? ";
			
			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, id);

			int removedRows = preparedStatement.executeUpdate();

			if (removedRows == 0) {
				throw new InstanceNotFoundException(id,Producto.class.getName());
			} 
			

			return removedRows;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}
		
	private void addClause(StringBuilder queryString, boolean first, String clause) {
		queryString.append(first? "WHERE ": " AND ").append(clause);
	}
	
	private void addUpdate(StringBuilder queryString, boolean first, String clause) {
		queryString.append(first? " SET ": " , ").append(clause);
	}
	
	private StringBuilder addCategoria(List<Categoria> categorias) {
		//Creamos la query en base al número de categorias que haya marcado el usuario
		boolean inner = true;
		StringBuilder lista = new StringBuilder();
		for (Categoria c : categorias) {
			lista.append(inner ? " (c.id_categoria LIKE "+c.getIdCategoria() : " OR " + c.getIdCategoria());
			inner=false;	
		}
		lista.append(" ) ");
		return lista;
	}
	private StringBuilder addNJugadores(List<NJugadores> njugadores) {
		//Creamos la query en base al número de jugadores que haya marcado el usuario
		boolean inner = true;
		StringBuilder lista = new StringBuilder();
		for (NJugadores n : njugadores) {
			lista.append(inner ? " (n.id_nJugadores LIKE "+n.getIdNJugadores() : " OR " + n.getIdNJugadores());
			inner=false;	
		}
		lista.append(" ) ");
		return lista;
	}
	private StringBuilder addIdioma(List<Idioma> idioma) {
		//Creamos la query en base al número de idioma que haya marcado el usuario
		boolean inner = true;
		StringBuilder lista = new StringBuilder();
		for (Idioma i : idioma) {
			lista.append(inner ? " (i.id_idioma LIKE "+ i.getIdIdioma() : " OR " + i.getIdIdioma());
			inner=false;	
		}
		lista.append(" ) ");
		return lista;
	}
	
	private Producto loadNext(Connection connection, ResultSet resultSet)
		throws SQLException, DataException {
			int i = 1;

			Long idProducto = resultSet.getLong(i++);
			String nombre = resultSet.getString(i++);	                
			Double precio = resultSet.getDouble(i++);
			Integer anio = resultSet.getInt(i++);
			String requisitos = resultSet.getString(i++);
			Long oferta = resultSet.getLong(i++);
			String detalles_largo = resultSet.getString(i++);
			String detalles_corto = resultSet.getString(i++);
			
			Producto p = new Producto();
			p.setIdProducto(idProducto);
			p.setNombre(nombre);
			p.setPrecio(precio);
			p.setAnio(anio);
			p.setRequisitos(requisitos);
			p.setOferta(oferta);
			p.setDetalles_largo(detalles_largo);
			p.setDetalles_corto(detalles_corto);
			
			return p;
	}

}