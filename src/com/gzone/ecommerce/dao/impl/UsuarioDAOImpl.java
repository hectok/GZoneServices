package com.gzone.ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gzone.ecommerce.dao.UsuarioDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Usuario;
import com.gzone.ecommerce.service.UsuarioCriteria;


public class UsuarioDAOImpl implements UsuarioDAO{
	
	public UsuarioDAOImpl() {
	}
	
	/*
	 * M�todo de b�squeda de un usuario por su ID
	 * 
	 */
	@Override
	public Usuario findById(Connection connection, Long id) 
			throws InstanceNotFoundException, DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {          
			String queryString = 
					"SELECT u.usuario, u.correo, u.nombre, u.apellido, u.descripcion" + 
							"FROM Usuario u  " +
							"WHERE u.id_usuario = ? ";
			
			preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;                
			preparedStatement.setLong(i++, id);

			resultSet = preparedStatement.executeQuery();

			Usuario e = null;

			if (resultSet.next()) {
				e = loadNext(connection, resultSet);				
			} else {
				throw new InstanceNotFoundException("User with id " + id + 
						"not found", Usuario.class.getName());
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
	 * M�todo para comprobar si un usuario existe
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
					"SELECT u.usuario, u.correo, u.nombre, u.apellido, u.descripcion" + 
							"FROM Usuario u  " +
							"WHERE u.id_usuario = ? ";

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
	 * M�todo para contar el n�mero total de usuarios.
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
							+ " FROM Usuario";

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
	 * M�todo de b�squeda por criteria.
	 * 
	 */
	@Override
	public List<Usuario> findByCriteria(Connection connection, UsuarioCriteria usuario, int startIndex, int count)
			throws DataException {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		StringBuilder queryString = null;

		try {
    
			queryString = new StringBuilder(
					" SELECT u.usuario, u.correo, u.nombre, u.apellido, u.descripcion" + 
					" FROM Usuario u ");
			
			// Marca (flag) de primera clausula, que se desactiva en la primera
			boolean first = true;
			
			if (usuario.getUsuario()!=null) {
				addClause(queryString, first, " UPPER(u.usuario) LIKE ? ");
				first = false;
			}
			
			if (usuario.getNombre()!=null) {
				addClause(queryString, first, " UPPER(u.nombre) LIKE ? ");
				first = false;
			}

			if (usuario.getCorreo()!=null) {
				addClause(queryString, first, " UPPER(u.correo) LIKE ? ");
				first = false;
			}			
			
			preparedStatement = connection.prepareStatement(queryString.toString(),
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int i = 1;       
			
			preparedStatement.setString(i++, "%" +  usuario.getUsuario() + "%");
			preparedStatement.setString(i++, "%" +  usuario.getNombre() + "%");
			preparedStatement.setString(i++, "%" +  usuario.getCorreo() + "%");

			resultSet = preparedStatement.executeQuery();
			
			List<Usuario> results = new ArrayList<Usuario>();                        
			Usuario e = null;
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
	public Usuario create(Connection connection, Usuario u) 
			throws DuplicateInstanceException, DataException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {          

			// Creamos el preparedstatement
			String queryString = "INSERT INTO Usuario(usario, correo, contrasena) "
					+ "VALUES (?, ?)";

			preparedStatement = connection.prepareStatement(queryString,
									Statement.RETURN_GENERATED_KEYS);

			// Fill the "preparedStatement"
			int i = 1;             
			preparedStatement.setString(i++, u.getNombre());
			preparedStatement.setString(i++, u.getCorreo());
			preparedStatement.setString(i++, u.getContrasena());

			// Execute query
			int insertedRows = preparedStatement.executeUpdate();

			if (insertedRows == 0) {
				throw new SQLException("Can not add row to table 'Shippers'");
			}

			// Recuperamos la PK generada
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				Long pk = resultSet.getLong(1); 
				u.setIdUsuario(pk);
			} else {
				throw new DataException("Unable to fetch autogenerated primary key");
			}

			// Return the DTO
			return u;

		} catch (SQLException e) {
			throw new DataException(e);
		} finally {
			JDBCUtils.closeResultSet(resultSet);
			JDBCUtils.closeStatement(preparedStatement);
		}
	}

	@Override
	public void update(Connection connection, Usuario u) 
			throws InstanceNotFoundException, DataException {
		PreparedStatement preparedStatement = null;
		try {			

			String queryString = 
					"UPDATE Usuario " +
					"SET nombre = ? , apellido = ? , descripcion = ?" +
					"WHERE id_usuario = ? ";

			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setString(i++, u.getNombre());
			preparedStatement.setString(i++, u.getNombre());
			preparedStatement.setLong(i++, u.getIdUsuario());

			int updatedRows = preparedStatement.executeUpdate();

			if (updatedRows == 0) {
				throw new InstanceNotFoundException(u.getIdUsuario(), Usuario.class.getName());
			}

			if (updatedRows > 1) {
				throw new SQLException("Duplicate row for id = '" + 
						u.getIdUsuario() + "' in table 'Customers'");
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
					  "DELETE FROM Usuario " 
					+ "WHERE id_usuario = ? ";
			
			preparedStatement = connection.prepareStatement(queryString);

			int i = 1;
			preparedStatement.setLong(i++, id);

			int removedRows = preparedStatement.executeUpdate();

			if (removedRows == 0) {
				throw new InstanceNotFoundException(id,Usuario.class.getName());
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
	 * @param queryString Consulta en elaboraci�n
	 * @param first Marca de primera clausula a�adida
	 * @param clause clausula a a�adir.
	 */
	private void addClause(StringBuilder queryString, boolean first, String clause) {
		queryString.append(first?" WHERE ": " AND ").append(clause);
	}
	
	private Usuario loadNext(Connection connection, ResultSet resultSet)
		throws SQLException, DataException {

			int i = 1;
			Long idUsuario = resultSet.getLong(i++);	                
			String usuario = resultSet.getString(i++);	                
			String correo = resultSet.getString(i++);
			String contrasena = resultSet.getString(i++);
			String nombre = resultSet.getString(i++);	                
			String apellido = resultSet.getString(i++);	                
			String descripcion = resultSet.getString(i++);
			Long localizacion = resultSet.getLong(i++);
		
			Usuario u = new Usuario();		
			u.setIdUsuario(idUsuario);
			u.setUsuario(usuario);
			u.setCorreo(correo);
			u.setContrasena(contrasena);
			u.setNombre(nombre);
			u.setApellido(apellido);
			u.setDescripcion(descripcion);
			u.setLocalizacion(localizacion);
			
			// Nota Jose A: Esta estrategia de recuperaci�n genera N+1 consultas.
			// Hibernate permite otra estrategia de recuperacion m�s eficiente:
			// Ejecutar los JOIN y recuperar tambi�n la entidad
			// padre del resultSet de todos ellos, con lo que es solamente 1 consulta.
			
			return u;
		}
		
}