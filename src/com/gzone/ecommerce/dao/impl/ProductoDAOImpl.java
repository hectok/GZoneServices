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

import com.gzone.ecommerce.dao.CategoriaDAO;
import com.gzone.ecommerce.dao.NJugadoresDAO;
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
 * @author Hector
 *
 */
public class ProductoDAOImpl implements ProductoDAO{
	
	private CategoriaDAO categoriaDAO = null;
	private NJugadoresDAO njugadoresDAO = null;

	public ProductoDAOImpl() {
		categoriaDAO = new CategoriaDAOImpl();
		njugadoresDAO = new NJugadoresDAOImpl();
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
	public Producto findById(Connection connection, Long id) 
			throws InstanceNotFoundException, DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {          

			String queryString = 
					" SELECT p.id_producto, p.nombre, p.precio, p.anio, p.requisitos, p.id_oferta " + 
					" FROM Producto p " +
					" WHERE p.id_producto = ? ";

			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setLong(i++, id);

			// Execute query            
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
	public List<Producto> findByCriteria(Connection connection, ProductoCriteria producto, int startIndex, int count)
			throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuilder queryString = null;

		try {
    
			queryString = new StringBuilder(
					" SELECT p.id_producto, p.nombre, p.precio, p.anio, p.requisitos, p.id_oferta " + 
					" FROM Producto p ");
			
			// Marca (flag) de primera clausula, que se desactiva en la primera
			boolean first = true;
			
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
				throw new DataException(e);
			} finally {
				JDBCUtils.closeResultSet(resultSet);
				JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
	@Override
	public List<Producto> findAll(Connection connection, 
			int startIndex, int count) 
					throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			// Create "preparedStatement"       
			String queryString = 
					"SELECT p.id_producto, p.nombre, p.precio, p.anio, p.requisitos,p.id_oferta " + 
					"FROM Producto p  " +
					"ORDER BY p.nombre asc ";

			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

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
			String queryString = "INSERT INTO Producto(nombre,precio,anio,requisitos,id_oferta) "
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

			// Inserta los demograficos
			createCategoria(connection, p.getIdProducto(), p.getCategorias());
			createNJugadores(connection, p.getIdProducto(), p.getNjugadores());
			createIdioma(connection, p.getIdProducto(), p.getIdioma());
			
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
		queryString.append(first? " WHERE ": " AND ").append(clause);
	}
	
	private void addUpdate(StringBuilder queryString, boolean first, String clause) {
		queryString.append(first? " SET ": " , ").append(clause);
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
	
			Producto p = new Producto();
			p.setIdProducto(idProducto);
			p.setNombre(nombre);
			p.setPrecio(precio);
			p.setAnio(anio);
			p.setRequisitos(requisitos);
			p.setOferta(oferta);
			
			List<Categoria> categorias = categoriaDAO.findByProducto(connection, idProducto);
			p.setCategorias(categorias);
			
			List<NJugadores> njugadores = njugadoresDAO.findByProducto(connection, idProducto);
			p.setNjugadores(njugadores);
			
			return p;
		}

	protected void createCategoria(Connection connection, Long idProducto,  List<Categoria> categorias)
			throws SQLException, DataException {

		PreparedStatement preparedStatement = null;
		try {          
			String queryString = null;
			int i;
			for (Categoria c: categorias) {
				queryString = "INSERT INTO Producto_Categoria (id_producto, id_categoria ) VALUES (?,  ?)";
				preparedStatement = connection.prepareStatement(queryString);				

				i = 1;     
				preparedStatement.setLong(i++, idProducto);
				preparedStatement.setLong(i++, c.getIdCategoria());

				int insertedRows = preparedStatement.executeUpdate();

				if (insertedRows == 0) {
					throw new SQLException("Can not add row to table 'Producto_Categoria'");
				}	

				JDBCUtils.closeStatement(preparedStatement);
			} 
		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
	protected void deleteCategoria(Connection c, Long idProducto)
		throws SQLException, DataException {

		PreparedStatement preparedStatement = null;

		try {

			String queryString =	
					  "DELETE FROM Producto_Categoria " 
					+ "WHERE id_producto = ? ";
			
			preparedStatement = c.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, idProducto);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
	protected void createNJugadores(Connection connection, Long idProducto,  List<NJugadores> njugadores)
			throws SQLException, DataException {

		PreparedStatement preparedStatement = null;
		try {          
			String queryString = null;
			int i;
			for (NJugadores c: njugadores) {
				queryString = "INSERT INTO Producto_NJugadores (id_producto, id_njugador ) VALUES (?,  ?)";
				preparedStatement = connection.prepareStatement(queryString);				

				i = 1;     
				preparedStatement.setLong(i++, idProducto);
				preparedStatement.setLong(i++, c.getIdNJugadores());

				int insertedRows = preparedStatement.executeUpdate();

				if (insertedRows == 0) {
					throw new SQLException("Can not add row to table 'Producto_NJugadores'");
				}	

				JDBCUtils.closeStatement(preparedStatement);
			} 
		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
	protected void deleteNJugadores(Connection c, Long idProducto)
		throws SQLException, DataException {

		PreparedStatement preparedStatement = null;

		try {

			String queryString =	
					  "DELETE FROM Producto_Producto_NJugadores " 
					+ "WHERE id_producto = ? ";
			
			preparedStatement = c.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, idProducto);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
	protected void createIdioma(Connection connection, Long idProducto,  List<Idioma> idioma)
			throws SQLException, DataException {

		PreparedStatement preparedStatement = null;
		try {          
			String queryString = null;
			int i;
			for (Idioma c: idioma) {
				queryString = "INSERT INTO Producto_Idioma_Disponible (id_producto, id_categoria ) VALUES (?,  ?)";
				preparedStatement = connection.prepareStatement(queryString);				

				i = 1;     
				preparedStatement.setLong(i++, idProducto);
				preparedStatement.setString(i++, c.getIdIdioma());

				int insertedRows = preparedStatement.executeUpdate();

				if (insertedRows == 0) {
					throw new SQLException("Can not add row to table 'Producto_Idioma'");
				}	

				JDBCUtils.closeStatement(preparedStatement);
			} 
		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
	protected void deleteIdioma(Connection c, Long idProducto)
		throws SQLException, DataException {

		PreparedStatement preparedStatement = null;

		try {

			String queryString =	
					  "DELETE FROM Producto_Idioma_Disponible " 
					+ "WHERE id_producto = ? ";
			
			preparedStatement = c.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, idProducto);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
}