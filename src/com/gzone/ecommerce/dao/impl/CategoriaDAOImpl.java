package com.gzone.ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gzone.ecommerce.dao.CategoriaDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

		public CategoriaDAOImpl() {
		}

		@Override
		public Boolean exists(Connection connection, Long id) 
				throws DataException {
			
			boolean exist = false;

			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {

				String queryString = "SELECT c.id_categoria " 
						+ "FROM Categoria c "
						+ "WHERE c.id_categoria = ? ";

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
		public List<Categoria> findAll(Connection connection, int startIndex, int count) throws DataException {

			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {

				String queryString = "SELECT c.id_categoria " 
						+ "FROM Categoria c ";

				preparedStatement = connection.prepareStatement(queryString, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				resultSet = preparedStatement.executeQuery();

				List<Categoria> results = new ArrayList<Categoria>();
				Categoria e = null;
				int currentCount = 0;

				if ((startIndex >= 1) && resultSet.absolute(startIndex)) {
					do {
						e = loadNext(resultSet);
						results.add(e);
						currentCount++;
					} while ((currentCount < count) && resultSet.next());
				}

				return results;

			} catch (SQLException e) {
				throw new DataException(e);
			} finally {
				JDBCUtils.closeResultSet(resultSet);
				JDBCUtils.closeStatement(preparedStatement);
			}
		}

		public List<Categoria> findByProducto(Connection connection, Long idProducto) 
				throws DataException {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {

				String queryString = "SELECT c.id_categoria, i.nombre_categoria " 
						+ " FROM Categoria c "
						+ " INNER JOIN Categoria_Idioma i ON c.id_categoria = i.id_categoria "
						+ " INNER JOIN Producto_categoria pc ON c.id_categoria = pc.id_categoria "
						+ " INNER JOIN Producto p  ON p.id_producto = cp.id_producto = ? ";

				preparedStatement = connection.prepareStatement(queryString, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				int i = 1;
				preparedStatement.setLong(i++, idProducto);

				resultSet = preparedStatement.executeQuery();

				List<Categoria> results = new ArrayList<Categoria>();

				Categoria e = null;

				while (resultSet.next()) {
					results.add(e);
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

				String queryString = " SELECT count(*) " 
									+" FROM Categoria";

				preparedStatement = connection.prepareStatement(queryString);

				resultSet = preparedStatement.executeQuery();

				int i = 1;
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

		private Categoria loadNext(ResultSet resultSet) throws SQLException {

			int i = 1;
			Long idCategoria = resultSet.getLong(i++);


			Categoria c = new Categoria();
			c.setIdCategoria(idCategoria);


			return c;
		}
		
		@Override
		public Categoria create(Connection connection, Categoria c) 
				throws DuplicateInstanceException, DataException {

			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {          

				String queryString = "INSERT INTO Categoria(id_categoria) "
						+ "VALUES (?)";

				preparedStatement = connection.prepareStatement(queryString,
										Statement.RETURN_GENERATED_KEYS);

				int i = 1;             
				preparedStatement.setLong(i++, c.getIdCategoria());

				int insertedRows = preparedStatement.executeUpdate();

				if (insertedRows == 0) {
					throw new SQLException("Can not add row to table 'Categoria'");
				} 

				// Recuperamos la PK generada
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					Long pk = resultSet.getLong(1); 
					c.setIdCategoria(pk);
				} else {
					throw new DataException("Unable to fetch autogenerated primary key");
				}

				// Return the DTO
				return c;

			} catch (SQLException e) {
				throw new DataException(e);
			} finally {
				JDBCUtils.closeResultSet(resultSet);
				JDBCUtils.closeStatement(preparedStatement);
			}
		}

		@Override
		public void update(Connection connection, Categoria c) 
				throws InstanceNotFoundException, DataException {
			
			PreparedStatement preparedStatement = null;
			try {

				String queryString = "UPDATE Categoria " 
						+ "SET CustomerDesc = ? "
						+ "WHERE CustomerTypeID = ? ";

				preparedStatement = connection.prepareStatement(queryString);

				int i = 1;
				preparedStatement.setLong(i++, c.getIdCategoria());

				int updatedRows = preparedStatement.executeUpdate();

				if (updatedRows == 0) {
					throw new InstanceNotFoundException(c.getIdCategoria(), Categoria.class.getName());
				}

				if (updatedRows > 1) {
					throw new SQLException(
							"Duplicate row for id = '" + c.getIdCategoria() + "' in table 'Categoria'");
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

				String queryString = "DELETE FROM Customerdemographics " 
								   + "WHERE CustomerTypeID = ? ";

				preparedStatement = connection.prepareStatement(queryString);

				int i = 1;
				preparedStatement.setLong(i++, id);

				int removedRows = preparedStatement.executeUpdate();

				if (removedRows == 0) {
					throw new InstanceNotFoundException(id, Categoria.class.getName());
				}
				return removedRows;

			} catch (SQLException e) {
				throw new DataException(e);
			} finally {
				JDBCUtils.closeStatement(preparedStatement);
			}

		}
}
