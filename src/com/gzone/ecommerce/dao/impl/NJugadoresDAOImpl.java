/**
 * 
 */
package com.gzone.ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gzone.ecommerce.dao.NJugadoresDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.NJugadores;

/**
 * @author hector.ledo.doval
 *
 */
public class NJugadoresDAOImpl implements NJugadoresDAO {
	
	public NJugadoresDAOImpl() {
	}
	
	/*
	 * Método de búsqueda de un NJugadores por su ID
	 * 
	 */
	@Override
	public NJugadores findById(Connection connection, Long id) 
			throws InstanceNotFoundException, DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {          
			String queryString = 
					"SELECT i.id_njugadores, i.njugadores " + 
							"FROM NJugadores i " +
							"WHERE i.id_njugadores = ? ";
			
			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setLong(i++, id);

			resultSet = preparedStatement.executeQuery();

			NJugadores e = null;

			if (resultSet.next()) {
				e = loadNext(connection, resultSet);				
			} else {
				throw new InstanceNotFoundException("Language with id " + id + 
						"not found", NJugadores.class.getName());
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
	 * Método para comprobar si un NJugadores existe
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
					"SELECT i.njugadores " + 
							"FROM NJugadores i " +
							"WHERE i.id_njugadores = ? ";

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
	 * Método para contar el número total de njugadoress
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
							+ " FROM NJugadores";

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
	public List<NJugadores> findAll(Connection connection, 
			int startIndex, int count) 
					throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			// Create "preparedStatement"       
			String queryString = 
					"SELECT i.id_njugadores, i.njugadores " + 
					"FROM NJugadores i " +	
					"ORDER BY i.njugadores asc ";

			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// Execute query.
			resultSet = preparedStatement.executeQuery();

			// Recupera la pagina de resultados
			List<NJugadores> results = new ArrayList<NJugadores>();                        
			NJugadores e = null;
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

	public List<NJugadores> findByProducto(Connection connection, Long idProducto) 
        	throws DataException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = 
					"SELECT n.id_nJugadores, n.njugadores " + 
					"FROM NJugadores n " 
						+ " INNER JOIN Producto_NJugadores pn ON n.id_nJugadores = pn.id_nJugadores " 
						+ " INNER JOIN Producto p " 
						+ " 	ON p.id_producto = pn.id_producto AND p.id_producto = ? ";
									
			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;
			preparedStatement.setLong(i++, idProducto);
			
			resultSet = preparedStatement.executeQuery();

			List<NJugadores> results = new ArrayList<NJugadores>();
			
			NJugadores p = null;
			
			while (resultSet.next()) {
					results.add(p);               	
			}				
			return results;

		} catch (SQLException p) {
			throw new DataException(p);
		} finally {
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}		 
	}	
	
	private NJugadores loadNext(Connection connection, ResultSet resultSet)
		throws SQLException, DataException {

			int i = 1;
			Long idNJugadores = resultSet.getLong(i++);	                
			String nombreNJugadores = resultSet.getString(i++);	                

	
			NJugadores njugadores = new NJugadores();		
			njugadores.setIdNJugadores(idNJugadores);
			njugadores.setnJugadores(nombreNJugadores);

			
			return njugadores;
		}	
	
}

