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
	
	protected void testExists() {
		logger.info("Testing exists ...");

		String id = "ES";
		
		try {			
			Boolean exists = idiomaService.exists(id);			
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

			List<Idioma> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = idiomaService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Idioma cat: results) {
						total++;
						logger.info("Result "+total+": "+ToStringUtil.toString(cat));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			logger.info("Found "+total+" results.");
						
		} catch (Throwable t) {
			logger.error(t);
		}
		logger.info("Test testFindAll finished.\n");
	}
	
	public static void main(String args[]) {
		IdiomaServiceTest test = new IdiomaServiceTest();
		test.testFindById();
		test.testExists();
		test.testFindAll();
	}
}



