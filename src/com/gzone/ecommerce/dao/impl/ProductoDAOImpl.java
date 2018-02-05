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

import com.gzone.ecommerce.dao.ProductoDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Producto;
import com.gzone.ecommerce.service.ProductoCriteria;

/**
 * @author Hector
 *
 */
public class ProductoDAOImpl implements ProductoDAO{

	public ProductoDAOImpl() {
	}
	
	/*
	 * Método de búsqueda de un Producto por su ID
	 * 
	 */
	@Override
	public Producto findById(Connection connection, Long id) 
			throws InstanceNotFoundException, DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {          
			String queryString = 
					"SELECT p.nombre, p.precio, p.anio,p.requisitos" + 
							"FROM Producto p  " +
							"WHERE p.id_producto = ? ";
			
			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setLong(i++, id);

			resultSet = preparedStatement.executeQuery();

			Producto e = null;

			if (resultSet.next()) {
				e = loadNext(connection, resultSet);				
			} else {
				throw new InstanceNotFoundException("Product with id " + id + 
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
					"SELECT p.nombre, p.precio,p.anio,p.requisitios" + 
							"FROM producto p  " +
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
					" SELECT p.nombre, p.precio,p.anio,p.requisitios" + 
					" FROM Producto p ");
			
			// Marca (flag) de primera clausula, que se desactiva en la primera
			boolean first = true;
			
			if (producto.getNombre()!=null) {
				addClause(queryString, first, " UPPER(p.nombre) LIKE ? ");
				first = false;
			}
			
			if (producto.getPrecio()!=null) {
				addClause(queryString, first, " UPPER(p.precio) LIKE ? ");
				first = false;
			}

			if (producto.getAnio()!=null) {
				addClause(queryString, first, " UPPER(p.anio) LIKE ? ");
				first = false;
			}			
			
			if (producto.getRequisitos()!=null) {
				addClause(queryString, first, " UPPER(p.requisitos) LIKE ? ");
				first = false;
			}	
			
			preparedStatement = connection.prepareStatement(queryString.toString(),
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;       
			
			preparedStatement.setString(i++, "%" +  producto.getNombre() + "%");
			preparedStatement.setString(i++, "%" +  producto.getPrecio() + "%");
			preparedStatement.setString(i++, "%" +  producto.getAnio() + "%");
			preparedStatement.setString(i++, "%" +  producto.getRequisitos() + "%");

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
					"SELECT p.id_producto, p.nombre,p.precio,p.anio,p.requisitos " + 
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
			String queryString = "INSERT INTO Producto(nombre,precio,anio,requisitos) "
					+ "VALUES (?, ?)";

			preparedStatement = connection.prepareStatement(queryString,
									Statement.RETURN_GENERATED_KEYS);

			// Fill the "preparedStatement"
			int i = 1;             
			preparedStatement.setString(i++, p.getNombre());
			preparedStatement.setDouble(i++, p.getPrecio());
			preparedStatement.setLong(i++, p.getAnio());
			preparedStatement.setString(i++, p.getRequisitos());
			// Execute query
			int insertedRows = preparedStatement.executeUpdate();

			if (insertedRows == 0) {
				throw new SQLException("Can not add row to table 'Shippers'");
			}

			// Recuperamos la PK generada
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				Long pk = resultSet.getLong(1); 
				p.setIdProducto(pk);
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
	public void update(Connection connection, Producto p) 
			throws InstanceNotFoundException, DataException {
		PreparedStatement preparedStatement = null;
		try {			

			String queryString = 
					"UPDATE Producto " +
					"SET nombre = ? , precio = ? , anio = ? , requisitos = ?" +
					"WHERE id_producto = ? ";

			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setString(i++, p.getNombre());
			preparedStatement.setString(i++, p.getNombre());
			preparedStatement.setDouble(i++, p.getPrecio());
			preparedStatement.setLong(i++, p.getAnio());
			preparedStatement.setLong(i++, p.getIdProducto());


			int updatedRows = preparedStatement.executeUpdate();

			if (updatedRows == 0) {
				throw new InstanceNotFoundException(p.getIdProducto(), Producto.class.getName());
			}

			if (updatedRows > 1) {
				throw new SQLException("Duplicate row for id = '" + 
						p.getIdProducto() + "' in table 'Customers'");
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
		
	/**
	 * Evita indexOf cada vez, simplemente con un marca booleana.
	 * @param queryString Consulta en elaboración
	 * @param first Marca de primera clausula añadida
	 * @param clause clausula a añadir.
	 */
	private void addClause(StringBuilder queryString, boolean first, String clause) {
		queryString.append(first?" WHERE ": " AND ").append(clause);
	}
	
	private Producto loadNext(Connection connection, ResultSet resultSet)
		throws SQLException, DataException {

			int i = 1;
			Long idProducto = resultSet.getLong(i++);	                
			String nombre = resultSet.getString(i++);	                
			Double precio = resultSet.getDouble(i++);
			Long anio = resultSet.getLong(i++);
			String requisitos = resultSet.getString(i++);
		
			Producto p = new Producto();		
			p.setIdProducto(idProducto);
			p.setNombre(nombre);
			p.setPrecio(precio);
			p.setAnio(anio);
			p.setRequisitos(requisitos);
			

			return p;
		}
		
}