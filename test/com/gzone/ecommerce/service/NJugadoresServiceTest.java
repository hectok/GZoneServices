/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.model.NJugadores;
import com.gzone.ecommerce.service.impl.NJugadoresServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;

/**
 * @author hector.ledo.doval
 *
 */
public class NJugadoresServiceTest {
	
	private static Logger logger = LogManager.getLogger(NJugadoresServiceTest.class.getName());

	private NJugadoresService njugadoresService = null;
	
	public NJugadoresServiceTest() {
		njugadoresService = new NJugadoresServiceImpl();
	}
	
	protected void testFindById() {
		logger.info("Testing findById ...");
		
		Long id = 1L;
		
		try {			
			NJugadores cat = njugadoresService.findById(id);			
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
			List<NJugadores> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = njugadoresService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (NJugadores p: results) {
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
		
		try {			
			List<NJugadores> nj = njugadoresService.findByProducto(id,1,1);		
			logger.info("Found: "+ToStringUtil.toString(nj));
			
			for (NJugadores bucle: nj) {
				System.out.println(bucle.getnJugadores());
			}
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test testFindById finished.\n");		
	}
	
	public static void main(String args[]) {
		NJugadoresServiceTest test = new NJugadoresServiceTest();
		test.testFindAll();
//		test.testFindById();
//		test.testFindByProducto();
	}
}



