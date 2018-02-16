/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.model.NJugadores;
import com.gzone.ecommerce.service.impl.NJugadoresServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;

/**
 * @author hector.ledo.doval
 *
 */
public class NJugadoresServiceTest {
	
private NJugadoresService njugadoresService = null;
	
	public NJugadoresServiceTest() {
		njugadoresService = new NJugadoresServiceImpl();
	}
	
	protected void testFindById() {
		System.out.println("Testing findById ...");
		
		Long id = 1L;
		
		try {			
			NJugadores cat = njugadoresService.findById(id);			
			System.out.println("Found: "+ToStringUtil.toString(cat));
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("Test testFindById finished.\n");		
	}
	
	protected void testExists() {
		System.out.println("Testing exists ...");

		Long id = 2L;
		
		try {			
			Boolean exists = njugadoresService.exists(id);			
			System.out.println("Exists: "+id+" -> "+exists);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("Test exists finished.\n");		
	}
	
	protected void testFindAll() {
		System.out.println("Testing findAll ...");
		
		int pageSize = 2; 	
		
		try {

			List<NJugadores> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = njugadoresService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					System.out.println("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (NJugadores cat: results) {
						total++;
						System.out.println("Result "+total+": "+ToStringUtil.toString(cat));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			System.out.println("Found "+total+" results.");
						
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test testFindAll finished.\n");
	}
	
	public static void main(String args[]) {
		NJugadoresServiceTest test = new NJugadoresServiceTest();
		test.testFindById();
		test.testExists();
		test.testFindAll();
	}
}



