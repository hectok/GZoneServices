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

import com.gzone.ecommerce.dao.LineaTicketDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.LineaTicket;
import com.gzone.ecommerce.model.LineaTicketId;
import com.gzone.ecommerce.model.Usuario;


/**
 * @author hector.ledo.doval
 *
 */
public class LineaTicketDAOImpl implements LineaTicketDAO{

public LineaTicketDAOImpl() {}
	
	@Override
	public LineaTicket findById(Connection connection, LineaTicketId id) 
			throws InstanceNotFoundException, DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {          
			String queryString = 
					"SELECT l.cod_compra,l.producto_id,l.precio" + 
							"FROM Lista_Ticket l  " +
							"WHERE l.cod_compra = ? AND l.producto_id = ? ";
			
			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setLong(i++, id.getIdTicket());
			preparedStatement.setLong(i++, id.getIdProducto());

			resultSet = preparedStatement.executeQuery();

			LineaTicket lt = null;

			if (resultSet.next()) {
				lt = loadNext(connection, resultSet);				
			} else {
				throw new InstanceNotFoundException("OrderDetails not found", Usuario.class.getName());
			}

			return lt;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {            
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}  
	}
	
	@Override
	public Boolean exists(Connection connection, LineaTicketId id) 
			throws DataException {
		
		boolean exist = false;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = 
					"SELECT l.cod_compra,l.producto_id " + 
							"FROM LineaTicket l " +
							"WHERE l.cod_compra = ? AND l.producto_id = ? ";

			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, id.getIdTicket());
			preparedStatement.setLong(i++, id.getIdProducto());

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


	@Override
	public List<LineaTicket> findByTicket (Connection connection, Long idTicket)
			throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = 
					"SELECT l.cod_compra,l.producto_id,l.precio" + 
					"FROM Lista_Ticket l " +
						"INNER JOIN Ticket t "+
						"ON l.cod_compra = t.cod_compra AND t.cod_compra = ? ";

			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setLong(i++, idTicket);

			resultSet = preparedStatement.executeQuery();

			List<LineaTicket> results = new ArrayList<LineaTicket>();  
			
			LineaTicket lt = null;
			
			while (resultSet.next()) {
				lt = loadNext (connection,resultSet);
				results.add(lt);
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
	public LineaTicket create(Connection connection, LineaTicket lt) 
			throws DuplicateInstanceException, DataException {

		PreparedStatement preparedStatement = null;
		
		LineaTicketId id = new LineaTicketId();
		id.setIdTicket(lt.getIdTicket());
		id.setIdProducto(lt.getIdProducto());
		
		try {          
			
			if (exists(connection, id)) {
				throw new DuplicateInstanceException(id, LineaTicket.class.getName());
			}
						
			String queryString = "INSERT INTO Linea_Ticket(cod_compra,producto_id,precio) "
					+ "VALUES (?, ?, ?)";

			preparedStatement = connection.prepareStatement(queryString);
			
			int i = 1;     
			preparedStatement.setLong(i++,lt.getIdTicket());
			preparedStatement.setLong(i++,lt.getIdProducto());
			preparedStatement.setDouble(i++,lt.getPrecio());

			
			int insertedRows = preparedStatement.executeUpdate();

			if (insertedRows == 0) {
				throw new SQLException("Can not add row to table 'Ticket'");
			}
			
			return lt;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}


	@Override
	public long delete(Connection connection, LineaTicketId id) 
			throws InstanceNotFoundException, DataException {
		PreparedStatement preparedStatement = null;

		try {

			String queryString =	
					  "DELETE FROM Linea_Ticket " 
					+ "WHERE cod_compra = ? AND producto_id = ? ";
			
			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, id.getIdTicket());
			preparedStatement.setLong(i++,id.getIdProducto());

			int removedRows = preparedStatement.executeUpdate();

			if (removedRows == 0) {
				throw new InstanceNotFoundException(id,LineaTicket.class.getName());
			} 
					
			return removedRows;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}
	
	
	private LineaTicket loadNext(Connection connection, ResultSet resultSet)
		throws SQLException, DataException {

			int i = 1;
			Long idTicket = resultSet.getLong(i++);	                
			Long idProducto = resultSet.getLong(i++);	                
			Double precio = resultSet.getDouble(i++);
                
	
			LineaTicket lt = new LineaTicket();		
			lt.setIdProducto(idProducto);
			lt.setIdTicket(idTicket);
			lt.setPrecio(precio);
			
			return lt;
		}

}

