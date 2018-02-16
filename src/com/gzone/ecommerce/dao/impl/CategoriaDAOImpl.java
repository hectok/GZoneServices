package com.gzone.ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gzone.ecommerce.dao.CategoriaDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.model.Categoria;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;

public class CategoriaDAOImpl implements CategoriaDAO {

		public CategoriaDAOImpl() {
		}
		
		@Override
		public Categoria findById(Connection connection, Long id) 
				throws InstanceNotFoundException, DataException {

			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {          

				String queryString = 
								"SELECT c.id_categoria, ci.categoria " + 
								"FROM Categoria c  " +
								"INNER JOIN Categoria_Idioma ci ON c.id_categoria = ci.id_categoria " +
								"WHERE c.id_categoria = ?";


				preparedStatement = connection.prepareStatement(queryString,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				int i = 1;                
				preparedStatement.setLong(i++, id);

				// Execute query            
				resultSet = preparedStatement.executeQuery();

				Categoria e = null;

				if (resultSet.next()) {
					e = loadNext(resultSet);				
				} else {
					throw new InstanceNotFoundException("Categories with id " + id + 
							"not found", Categoria.class.getName());
				}

				return e;

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
								"SELECT c.id_categoria, ci.categoria " + 
								"FROM Categoria c  " +
								"INNER JOIN Categoria_Idioma ci ON c.id_categoria = ci.id_categoria " +
								"WHERE c.id_categoria = ?";


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

				String queryString = 
						"SELECT c.id_categoria, ci.categoria " + 
						"FROM Categoria c  " +
						"INNER JOIN Categoria_Idioma ci ON c.id_categoria = ci.id_categoria ";
						


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

		public List<Categoria> findByCategoria(Connection connection, Long idProducto, int startIndex, int count) 
				throws DataException {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {

				String queryString = 
									"SELECT ci.id_categoria " +
									"FROM categoria_idioma ci " +
										"INNER JOIN categoria c ON c.id_categoria=ci.id_categoria " +
									    "INNER JOIN producto_categoria cp ON c.id_categoria=cp.id_categoria " +
									    "INNER JOIN producto p ON cp.id_producto=p.id_producto " +
									"WHERE ci.id_categoria = ?";

				preparedStatement = connection.prepareStatement(queryString, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				int i = 1;
				preparedStatement.setLong(i++, idProducto);

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
}

