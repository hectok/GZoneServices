package com.gzone.ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.dao.CategoriaDAO;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {
		
		private static Logger logger = LogManager.getLogger(CategoriaDAOImpl.class.getName());
	
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
		public List<Categoria> findAll(Connection connection,int startIndex, int count, String idioma) 
				throws DataException {

			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {

			String queryString = 
					"SELECT c.id_categoria, ci.categoria " + 
							"FROM Categoria c  " +
							"INNER JOIN Categoria_Idioma ci ON c.id_categoria = ci.id_categoria " +
							"WHERE ci.id_idioma LIKE ? ";

				preparedStatement = connection.prepareStatement(queryString,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				int i = 1;                
				preparedStatement.setString(i++, idioma);
				
				resultSet = preparedStatement.executeQuery();

				List<Categoria> results = new ArrayList<Categoria>();                        
				Categoria t = null;
				int currentCount = 0;

				if ((startIndex >=1) && resultSet.absolute(startIndex)) {
					do {
						t = loadNext(resultSet);
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

		public List<Categoria> findByProducto(Connection connection, Long idProducto,int startIndex, int count, String idioma) 
				throws DataException {
			
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {

				String queryString = (
										"select pc.id_categoria, ci.categoria " +
										"from Producto_categoria pc " +
										"inner join categoria c on pc.id_categoria=c.id_categoria " +
										"inner join categoria_idioma ci on ci.id_categoria=c.id_categoria " +
										"where pc.id_producto = ? AND ci.id_idioma= ? ");


				preparedStatement = connection.prepareStatement(queryString,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				int i = 1;
				preparedStatement.setLong(i++, idProducto);
				preparedStatement.setString(i++, idioma);

				resultSet = preparedStatement.executeQuery();

				// Recupera la pagina de resultados
				List<Categoria> results = new ArrayList<Categoria>();                        
				Categoria e = null;
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

		
		private Categoria loadNext(ResultSet resultSet) 
				throws SQLException, DataException {

			int i = 1;
			Long idCategoria = resultSet.getLong(i++);
			String categoria = resultSet.getString(i++);

			Categoria c = new Categoria();
			c.setIdCategoria(idCategoria);
			c.setCategoria(categoria);

			return c;
		}

}

