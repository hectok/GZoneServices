/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.model.Categoria;
import com.gzone.ecommerce.model.Producto;
import com.gzone.ecommerce.service.impl.CategoriaServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;

/**
 * @author hector.ledo.doval
 *
 */
public class CategoriaServiceTest {

	private static Logger logger = LogManager.getLogger(CategoriaServiceTest.class.getName());

	private CategoriaService categoriaService = null;
	
	public CategoriaServiceTest() {
		categoriaService = new CategoriaServiceImpl();
	}
	
	protected void testFindById() {
		logger.info("Testing findById ...");
		
		Long id = (long) 1;
		
		try {			
			Categoria cat = categoriaService.findById(id);			
			logger.info("Found: "+ToStringUtil.toString(cat));
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test testFindById finished.\n");		
	}
	
	protected void testExists() {
		logger.info("Testing exists ...");

		Long id = (long) 1;
		
		try {			
			Boolean exists = categoriaService.exists(id);			
			logger.info("Exists: "+id+" -> "+exists);
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test exists finished.\n");		
	}
	
	protected void testFindAll() {
		logger.info("Testing findAll ...");
		
		int pageSize = 2; 	
		
		try {

			List<Categoria> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = categoriaService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Categoria cat: results) {
						total++;
						logger.info("Result "+total+": "+ToStringUtil.toString(cat));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			logger.info("Found "+total+" results.");
						
		} catch (Throwable t) {
			logger.error( t);
		}
		logger.info("Test testFindAll finished.\n");
	}
	
	protected void testFindByProducto() {
		logger.info("Testing findByCategoria ...");
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		Categoria e = new Categoria();
		e.setIdCategoria(22L);
		categorias.add(e);
		Categoria i = new Categoria();
		i.setIdCategoria(6L);
		categorias.add(i);
		int pageSize = 2;
		
		try {

			List<Producto> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = categoriaService.findByProducto(categorias, startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Producto t: results) {
						total++;
						logger.info("Result "+total+": "+ToStringUtil.toString(t));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			logger.info("Found "+total+" results.");
						
		} catch (Throwable t) {
			logger.error("id = "+e.getIdCategoria(), t);
		}
		logger.info("Test FindByCriteria finished.\n");
	}
	
	public static void main(String args[]) {
		CategoriaServiceTest test = new CategoriaServiceTest();
//		test.testFindById();
//		test.testExists();
//		test.testFindAll();
		test.testFindByProducto();	
	}
}

