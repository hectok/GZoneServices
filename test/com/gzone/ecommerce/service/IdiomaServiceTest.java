/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.model.Idioma;
import com.gzone.ecommerce.service.IdiomaService;
import com.gzone.ecommerce.service.impl.IdiomaServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;

/**
 * @author hector.ledo.doval
 *
 */
public class IdiomaServiceTest {
	
	private static Logger logger = LogManager.getLogger(IdiomaServiceTest.class.getName());
	
	private IdiomaService idiomaService = null;
	
	public IdiomaServiceTest() {
		idiomaService = new IdiomaServiceImpl();
	}
	
	protected void testFindById() {
		logger.info("Testing findById ...");
		
		String id = "ES";
		
		try {			
			Idioma cat = idiomaService.findById(id);			
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
			List<Idioma> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = idiomaService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Idioma p: results) {
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
		
		Long id = (long) 5;
		
		try {			
			List<Idioma> nj = idiomaService.findByProducto(id,1,2);		
			logger.info("Found: "+ToStringUtil.toString(nj));
			
			for (Idioma bucle: nj) {
				System.out.println(bucle.getNombreIdioma());
			}
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test testFindById finished.\n");		
	}
	
	public static void main(String args[]) {
		IdiomaServiceTest test = new IdiomaServiceTest();
//		test.testFindById();
//		test.testFindByProducto();
		test.testFindAll();
	}
}



