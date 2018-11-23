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
	
	protected void testFindAll() {
		logger.info("Testing findAll ...");
		int pageSize = 10; 	
		
		try {
			String idioma = "EN";
			List<Categoria> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = categoriaService.findAll(startIndex, pageSize,idioma);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Categoria p: results) {
						total++;
						logger.info("Result "+total+": "+ToStringUtil.toString(p));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			logger.info("Found "+total+" results.");
						
		} catch (Throwable c) {
			c.printStackTrace();
		}
		logger.info("Test testFindAll finished.\n");
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
	
	public String holaHector() {
		return "Hector";
	}
	
	public static void main(String args[]) {
		CategoriaServiceTest test = new CategoriaServiceTest();
//		test.testFindById();
//		test.testExists();
		test.testFindAll();
//		test.testFindByProducto();
	}
}

