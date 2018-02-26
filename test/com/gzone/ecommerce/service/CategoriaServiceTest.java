/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.model.Categoria;
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
	
	protected void testFindByProducto() {
		logger.info("Testing testFindByProducto ...");
		
		Long id = (long) 6;
		String idioma= "ES";
		
		try {			
			List<Categoria> cat = categoriaService.findByProducto(id,1,1,idioma);			
			logger.info("Found: "+ToStringUtil.toString(cat));
			
			for (Categoria bucle: cat) {
				System.out.println(bucle.getCategoria());
			}
			
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
	
	
	public static void main(String args[]) {
		CategoriaServiceTest test = new CategoriaServiceTest();
//		test.testFindById();
//		test.testExists();
		test.testFindByProducto();
	}
}

