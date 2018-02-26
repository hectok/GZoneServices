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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	private static Logger logger = LogManager.getLogger(NJugadoresDAOImpl.class.getName());
	
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
				e = loadNext(resultSet);				
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
	
	public List<NJugadores> findByProducto(Connection connection, Long idProducto,int startIndex, int count) 
			throws DataException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = (
								"select pn.id_njugador, n.njugadores " + 
										"from producto_njugadores pn " + 
											"inner join njugadores n on pn.id_njugador=n.id_nJugadores " +
										"where pn.id_producto = ? ");


			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;
			preparedStatement.setLong(i++, idProducto);

			resultSet = preparedStatement.executeQuery();

			// Recupera la pagina de resultados
			List<NJugadores> results = new ArrayList<NJugadores>();                        
			NJugadores e = null;
			int currentCount = 0;

			if ((startIndex >=1) && resultSet.absolute(startIndex)) {
				do {
					e = loadNext(resultSet);
					results.add(e);               	
					currentCount++;                	
				} while ((currentCount < count) && resultSet.next()) ;
			}

			return results;
	
			} catch (SQLException e) {
				logger.error("startIndex: "+startIndex + ", count: "+count, e);
				throw new DataException(e);
			} finally {
				JDBCUtils.closeResultSet(resultSet);
				JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
	private NJugadores loadNext(ResultSet resultSet)
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

