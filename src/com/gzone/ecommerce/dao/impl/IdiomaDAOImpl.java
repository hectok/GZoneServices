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

import com.gzone.ecommerce.dao.IdiomaDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Idioma;


/**
 * @author hector.ledo.doval
 *
 */
public class IdiomaDAOImpl implements IdiomaDAO{
	
	private static Logger logger = LogManager.getLogger(ProductoDAOImpl.class.getName());
	
	public IdiomaDAOImpl() {
	}
	
	/*
	 * Método de búsqueda de un Idioma por su ID
	 * 
	 */
	@Override
	public Idioma findById(Connection connection, String id) 
			throws InstanceNotFoundException, DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {          
			String queryString = 
					"SELECT i.id_idioma, i.idioma " + 
							"FROM Idioma i " +
							"WHERE i.id_idioma = ? ";
			
			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setString(i++, id);

			resultSet = preparedStatement.executeQuery();

			Idioma e = null;

			if (resultSet.next()) {
				e = loadNext(resultSet);				
			} else {
				throw new InstanceNotFoundException("Language with id " + id + 
						"not found", Idioma.class.getName());
			}

			return e;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {            
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}  
	}

	public List<Idioma> findByProducto(Connection connection, Long idProducto,int startIndex, int count) 
			throws DataException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = (
								"select pid.id_idioma, i.idioma " + 
										"from Producto_Idioma_Disponible pid " + 
											"inner join Idioma i ON pid.id_idioma=i.id_idioma " +
										"where pid.id_producto = ? ");


			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;
			preparedStatement.setLong(i++, idProducto);

			resultSet = preparedStatement.executeQuery();

			// Recupera la pagina de resultados
			List<Idioma> results = new ArrayList<Idioma>();                        
			Idioma e = null;
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
		
	private Idioma loadNext(ResultSet resultSet)
		throws SQLException, DataException {

			int i = 1;
			String idIdioma = resultSet.getString(i++);	                
			String nombreIdioma = resultSet.getString(i++);	                

	
			Idioma idioma = new Idioma();		
			idioma.setIdIdioma(idIdioma);
			idioma.setNombreIdioma(nombreIdioma);

			
			return idioma;
		}		

}
