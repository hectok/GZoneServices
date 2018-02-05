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
import java.util.Date;
import java.util.List;

import com.gzone.ecommerce.dao.LineaTicketDAO;
import com.gzone.ecommerce.dao.TicketDAO;
import com.gzone.ecommerce.model.LineaTicket;
import com.gzone.ecommerce.model.Ticket;
import com.gzone.ecommerce.service.TicketCriteria;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;


/**
 * @author hector.ledo.doval
 *
 */
public class TicketDAOImpl implements TicketDAO {
	
	private LineaTicketDAO lineaTicketDAO = null;

	public TicketDAOImpl() {
		lineaTicketDAO  = new LineaTicketDAOImpl();
	}

	@Override
	public Ticket findById(Connection connection, Long id) 
			throws InstanceNotFoundException, DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {          
			String queryString = 
					"SELECT t.cantidad,t.fecha_compra,t.dir_facturacion,t.id_usuario" +
							"FROM Ticket t  " +
							"WHERE t.cod_compra = ? ";
			
			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setLong(i++, id);

			resultSet = preparedStatement.executeQuery();

			Ticket t = null;

			if (resultSet.next()) {
				t = loadNext(connection, resultSet);				
			} else {
				throw new InstanceNotFoundException("Ticket with id " + id + 
						"not found", Ticket.class.getName());
			}

			return t;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {            
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}  
	}

	@Override
	public Boolean exists(Connection connection, Long id) 
			throws DataException {
		boolean exist = false;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = 
					"SELECT t.cod_compra " + 
					"FROM Ticket t  " +
					"WHERE t.cod_compra = ? ";

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

	@Override
	public List<Ticket> findAll(Connection connection,int startIndex, int count) 
			throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

		String queryString = 
				"SELECT t.cantidad,t.fecha_compra,t.dir_facturacion,t.id_usuario" +
						"FROM Ticket t  " +
						"WHERE t.cod_compra = ? " +
						"ORDER BY t.fecha_compra DESC";

			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = preparedStatement.executeQuery();

			List<Ticket> results = new ArrayList<Ticket>();                        
			Ticket t = null;
			int currentCount = 0;

			if ((startIndex >=1) && resultSet.absolute(startIndex)) {
				do {
					t = loadNext(connection, resultSet);
					results.add(t);               	
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
	public long countAll(Connection connection) 
			throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			String queryString = 
					" SELECT count(*) "
							+ " FROM Ticket ";

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
	public List<Ticket> findByCriteria(Connection connection, TicketCriteria ticket, int startIndex, int count)
			throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuilder queryString = null;

		try {
    
			queryString = new StringBuilder(
					"SELECT t.cantidad,t.fecha_compra,t.dir_facturacion,t.id_usuario" +
					" FROM Ticket t ");
			
			boolean first = true;
			
			if (ticket.getCantidad()!=null) {
				addClause(queryString, first, " t.cantidad = ? ");
				first = false;
			}
			
			if (ticket.getFechaTicket()!=null) {
				addClause(queryString, first, " t.fecha_compra ");
				first = false;
			}

			if (ticket.getDirFacturacion()!=null) {
				addClause(queryString, first, " UPPER(t.dir_facturacion) LIKE ? ");
				first = false;
			}			
			
			if (ticket.getId_usuario()!=null) {
				addClause(queryString, first, " t.id_usuario ? ");
				first = false;
			}
			
			if (ticket.getCodCompra()!=null) {
				addClause(queryString, first, " t.cod_compra ? ");
				first = false;
			}
					
			
			preparedStatement = connection.prepareStatement(queryString.toString(),
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;       
			
			if (ticket.getCantidad()!=null) 
				preparedStatement.setDouble(i++, ticket.getCantidad());
			if (ticket.getFechaTicket()!=null) 
				preparedStatement.setDate(i++,(java.sql.Date) ticket.getFechaTicket());
			if (ticket.getDirFacturacion()!=null)
				preparedStatement.setString(i++,ticket.getDirFacturacion());
			if (ticket.getId_usuario()!=null) 
				preparedStatement.setLong(i++,ticket.getId_usuario());
			if (ticket.getCodCompra()!=null) 
				preparedStatement.setLong(i++,ticket.getCodCompra());

			resultSet = preparedStatement.executeQuery();
			
			List<Ticket> results = new ArrayList<Ticket>();                        
			Ticket t = null;
			int currentCount = 0;

			if ((startIndex >=1) && resultSet.absolute(startIndex)) {
				do {
					t = loadNext(connection, resultSet);
					results.add(t);               	
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
	
	
	private void addClause(StringBuilder queryString, boolean first, String clause) {
		queryString.append(first?" WHERE ": " AND ").append(clause);
	}
	
	private Ticket loadNext(Connection connection, ResultSet resultSet)
		throws SQLException, DataException {

			int i = 1;
			Long codCompra = resultSet.getLong(i++);
			Long cantidad = resultSet.getLong(i++);
			Date fechaTicket = resultSet.getDate(i++);
			String dirFacturacion = resultSet.getString(i++);	                
			Long id_usuario = resultSet.getLong(i++);
			

			Ticket t = new Ticket();		
			t.setCodCompra(codCompra);
			t.setCantidad(cantidad);
			t.setFechaTicket(fechaTicket);
			t.setDirFacturacion(dirFacturacion);
			t.setId_usuario(id_usuario);

			
			
			List<LineaTicket> lineasTicket = lineaTicketDAO.findByTicket(connection, codCompra);
			t.setLineas(lineasTicket);

			return t;
		}
	

	@Override
	public Ticket create(Connection connection, Ticket t) 
			throws DuplicateInstanceException, DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {          
			
			String queryString = "INSERT INTO Ticket(t.cantidad,t.fecha_compra,t.dir_facturacion,t.id_usuario" +
					"VALUES (?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(queryString,
					Statement.RETURN_GENERATED_KEYS);
			
			int i = 1;     
			preparedStatement.setLong(i++,t.getCantidad());
			preparedStatement.setDate(i++, (java.sql.Date) t.getFechaTicket());
			preparedStatement.setString(i++,t.getDirFacturacion());
			preparedStatement.setLong(i++, t.getId_usuario());


			int insertedRows = preparedStatement.executeUpdate();

			if (insertedRows == 0) {
				throw new SQLException("Can not add row to table 'Orders'");
			} 
			
			
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				Long pk = resultSet.getLong(1); 
				t.setCodCompra(pk);
			} else {
				throw new DataException("Unable to fetch autogenerated primary key");
			}
			
			List<LineaTicket> lineas = t.getLineas();
			for (LineaTicket lt: lineas) {
				lt.setIdTicket(t.getCodCompra());
				lineaTicketDAO.create(connection, lt);
			}
			
			return t;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}

	public void update(Connection connection, Ticket t) 
			throws InstanceNotFoundException, DataException {
		PreparedStatement preparedStatement = null;
		try {
			
			deleteLineasTicket(connection, t.getCodCompra());
			
			String queryString = 
					"UPDATE Ticket " +
					"SET cantidad = ?, fecha_compra = ?, dir_facturacion = ?" +
					"WHERE cod_compra = ? ";

			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, t.getCantidad());
			preparedStatement.setDate(i++, (java.sql.Date) t.getFechaTicket());
			preparedStatement.setString(i++, t.getDirFacturacion());

			int updatedRows = preparedStatement.executeUpdate();

			if (updatedRows == 0) {
				throw new InstanceNotFoundException(t.getCodCompra(), Ticket.class.getName());
			}

			if (updatedRows > 1) {
				throw new SQLException("Duplicate row for id = '" + 
						t.getCodCompra() + "' in table 'Orders'");
			}     
			
			createLineasTicket(connection, t.getCodCompra(), t.getLineas());

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
			
			deleteLineasTicket (connection, id);

			String queryString =	
					  "DELETE FROM Ticket " 
					+ "WHERE cod_compra = ? ";
			
			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, id);

			int removedRows = preparedStatement.executeUpdate();

			if (removedRows == 0) {
				throw new InstanceNotFoundException(id,Ticket.class.getName());
			} 
			return removedRows;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}

	}
	
	protected void deleteLineasTicket(Connection c, Long cod_compra)
			throws SQLException, DataException {

			PreparedStatement preparedStatement = null;

			try {

				String queryString =	
						  "DELETE FROM Lista_Ticket " 
						+ "WHERE cod_compra = ? ";
				
				preparedStatement = c.prepareStatement(queryString);

				int i = 1;
				preparedStatement.setLong(i++, cod_compra);

				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				throw new DataException(e);
			} finally {
				JDBCUtils.closeStatement(preparedStatement);
			}
		}
	
	protected void createLineasTicket(Connection connection, Long cod_compra,  List<LineaTicket> lineas)
			throws SQLException, DataException {

		PreparedStatement preparedStatement = null;
		try {          
			String queryString = null;
			int i;
			for (LineaTicket lt: lineas ) {
				queryString = "INSERT INTO Linea_Ticket (cod_compra,producto_id,precio) VALUES (?, ?, ?)";
				preparedStatement = connection.prepareStatement(queryString);				

				i = 1;     
				preparedStatement.setLong(i++, cod_compra);
				preparedStatement.setLong(i++, lt.getIdProducto());
				preparedStatement.setDouble(i++, lt.getPrecio());


				int insertedRows = preparedStatement.executeUpdate();

				if (insertedRows == 0) {
					throw new SQLException("Can not add row to table 'CustomerCustomerDemo'");
				}	

				JDBCUtils.closeStatement(preparedStatement);
			} 
		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeStatement(preparedStatement);
		}
	}

}
