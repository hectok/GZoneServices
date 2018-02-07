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

import com.gzone.ecommerce.dao.IdiomaDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Idioma;


/**
 * @author hector.ledo.doval
 *
 */
public class IdiomaDAOImpl implements IdiomaDAO{
	
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
					"SELECT i.nombre_idioma" + 
							"FROM Idioma  " +
							"WHERE i.id_idioma = ? ";
			
			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setString(i++, id);

			resultSet = preparedStatement.executeQuery();

			Idioma e = null;

			if (resultSet.next()) {
				e = loadNext(connection, resultSet);				
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

	/*
	 * Método para comprobar si un Idioma existe
	 * 
	 */
	@Override
	public Boolean exists(Connection connection, String id) 
			throws DataException {
		boolean exist = false;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = 
					"SELECT i.nombre_idioma" + 
							"FROM Idioma  " +
							"WHERE i.id_idioma = ? ";

			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setString(i++, id);

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
	 * Método para contar el número total de idiomas
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
							+ " FROM Idioma";

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
	public List<Idioma> findAll(Connection connection, 
			int startIndex, int count) 
					throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			// Create "preparedStatement"       
			String queryString = 
					"SELECT i.nombre_idioma" + 
					"FROM Idioma i " +	
					"ORDER BY i.nombre_idioma asc ";

			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// Execute query.
			resultSet = preparedStatement.executeQuery();

			// Recupera la pagina de resultados
			List<Idioma> results = new ArrayList<Idioma>();                        
			Idioma e = null;
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
	public Idioma create(Connection connection, Idioma idioma) 
			throws DuplicateInstanceException, DataException {

		PreparedStatement preparedStatement = null;
		try {          
			
			//Check if the primary key already exists
			if (exists(connection, idioma.getIdIdioma())) {
				throw new DuplicateInstanceException(idioma.getIdIdioma(), Idioma.class.getName());
			}
			
			//We establish the primary key based on the company name or the contact name depending if the first one has more than 5 letters. 
			String id = idioma.getIdIdioma();
			if (id.length()>3)
				throw new DataException("Unable to create primary key");

			
			String queryString = "INSERT INTO Idioma(id_idioma,nombre_idioma) "
					+ "VALUES (?, ?)";

			preparedStatement = connection.prepareStatement(queryString);
			
			int i = 1;     
			preparedStatement.setString(i++, id);
			preparedStatement.setString(i++, idioma.getNombreIdioma());


			int insertedRows = preparedStatement.executeUpdate();

			if (insertedRows == 0) {
				throw new SQLException("Can not add row to table 'Customers'");
			}
			

			idioma.getIdIdioma(); 
			
			return idioma;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}

	@Override
	public void update(Connection connection, Idioma idioma) 
			throws InstanceNotFoundException, DataException {
		PreparedStatement preparedStatement = null;
		try {			

			String queryString = 
					"UPDATE Idioma " +
					"SET nombre_idioma = ? " +
					"WHERE id_idioma = ? ";

			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setString(i++, idioma.getIdIdioma());
			preparedStatement.setString(i++, idioma.getNombreIdioma());



			int updatedRows = preparedStatement.executeUpdate();

			if (updatedRows == 0) {
				throw new InstanceNotFoundException(idioma.getIdIdioma(), Idioma.class.getName());
			}

			if (updatedRows > 1) {
				throw new SQLException("Duplicate row for id = '" + 
						idioma.getIdIdioma() + "' in table 'Idioma'");
			}     
			
		} catch (SQLException e) {
			throw new DataException(e);    
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}              		
	}

	@Override
	public long delete(Connection connection, String id) 
			throws InstanceNotFoundException, DataException {
		PreparedStatement preparedStatement = null;

		try {
			String queryString =	
					  "DELETE FROM Idioma " 
					+ "WHERE id_idioma = ? ";
			
			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setString(i++, id);

			int removedRows = preparedStatement.executeUpdate();

			if (removedRows == 0) {
				throw new InstanceNotFoundException(id,Idioma.class.getName());
			} 
			

			return removedRows;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}
		
	private Idioma loadNext(Connection connection, ResultSet resultSet)
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
