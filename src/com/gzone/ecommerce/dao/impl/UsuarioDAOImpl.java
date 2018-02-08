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
import com.gzone.ecommerce.util.PasswordEncryptionUtil;


public class UsuarioDAOImpl implements UsuarioDAO{
	
	public UsuarioDAOImpl() {
	}
	
	/*
	 * Método de búsqueda de un usuario por su ID
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
	 * Método para comprobar si un usuario existe
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
	 * Método para contar el número total de usuarios.
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
	 * Método de búsqueda por criteria.
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
			
			if (usuario.getUsuario()!=null) 
				preparedStatement.setString(i++, "%" + usuario.getUsuario() + "%");
			if (usuario.getCorreo()!=null) 
				preparedStatement.setString(i++, "%" + usuario.getCorreo() + "%");
			if (usuario.getNombre()!=null)
				preparedStatement.setString(i++, "%" + usuario.getNombre() + "%");
			if (usuario.getApellido()!=null) 
				preparedStatement.setString(i++, "%" + usuario.getApellido() + "%");
			if (usuario.getLocalizacion()!=null) 
				preparedStatement.setString(i++, "%" + usuario.getLocalizacion() + "%");

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

			// Rellenamos el "preparedStatement"
			int i = 1;    
			preparedStatement.setString(i++, u.getNombre());
			preparedStatement.setString(i++, u.getCorreo());
			preparedStatement.setString(i++, PasswordEncryptionUtil.encryptPassword(u.getContrasena()));

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
		StringBuilder queryString = null;
		try {	
			
			queryString = new StringBuilder(
					" UPDATE Producto" 
					);
			
			boolean first = true;
			
			if (u.getUsuario()!=null) {
				addUpdate(queryString, first, " usuario = ? ");
				first = false;
			}
			
			if (u.getCorreo()!=null) {
				addUpdate(queryString, first, " correo = ? ");
				first = false;
			}
			
			if (u.getContrasena()!=null) {
				addUpdate(queryString, first, "contrasena = ? ");
				first = false;
			}
			
			if (u.getNombre()!=null) {
				addUpdate(queryString, first, "nombre = ? ");
				first = false;
			}
			
			if (u.getApellido()!=null) {
				addUpdate(queryString, first, " apellido = ? ");
				first = false;
			}
			
			if (u.getDescripcion()!=null) {
				addUpdate(queryString, first, " descripcion = ? ");
				first = false;
			}
						
			queryString.append("WHERE id_producto = ?");
			
			preparedStatement = connection.prepareStatement(queryString.toString());
			

			int i = 1;
			if (u.getUsuario()!=null) 
				preparedStatement.setString(i++, "%" +  u.getUsuario() + "%");
			
			if (u.getCorreo()!=null) 
				preparedStatement.setString(i++, "%" +  u.getCorreo() + "%");
			
			if (u.getContrasena()!=null) 
				preparedStatement.setString(i++, "%" +  u.getContrasena() + "%");
			
			if (u.getNombre()!=null) 
				preparedStatement.setString(i++, "%" +  u.getNombre() + "%");
			
			if (u.getApellido()!=null) 
				preparedStatement.setString(i++, "%" +  u.getApellido() + "%");
			
			if (u.getDescripcion()!=null) 
				preparedStatement.setString(i++, "%" +  u.getDescripcion()+ "%");


			int updatedRows = preparedStatement.executeUpdate();

			if (updatedRows == 0) {
				throw new InstanceNotFoundException(u.getIdUsuario(), Usuario.class.getName());
			}

			if (updatedRows > 1) {
				throw new SQLException("Duplicate row for id = '" + 
						u.getIdUsuario() + "' in table 'Usuario'");
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
		
	private void addClause(StringBuilder queryString, boolean first, String clause) {
		queryString.append(first?" WHERE ": " AND ").append(clause);
	}
	
	private void addUpdate(StringBuilder queryString, boolean first, String clause) {
		queryString.append(first?" SET ": " , ").append(clause);
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
			
			// Nota Jose A: Esta estrategia de recuperación genera N+1 consultas.
			// Hibernate permite otra estrategia de recuperacion más eficiente:
			// Ejecutar los JOIN y recuperar también la entidad
			// padre del resultSet de todos ellos, con lo que es solamente 1 consulta.
			
			return u;
		}
		
}