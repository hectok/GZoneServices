/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.model.Idioma;
import com.gzone.ecommerce.service.IdiomaService;
import com.gzone.ecommerce.service.impl.IdiomaServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;

/**
 * @author hector.ledo.doval
 *
 */
public class IdiomaServiceTest {
	
	private IdiomaService idiomaService = null;
	
	public IdiomaServiceTest() {
		idiomaService = new IdiomaServiceImpl();
	}
	
	protected void testFindById() {
		System.out.println("Testing findById ...");
		
		String id = "ES";
		
		try {			
			Idioma cat = idiomaService.findById(id);			
			System.out.println("Found: "+ToStringUtil.toString(cat));
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("Test testFindById finished.\n");		
	}
	
	protected void testExists() {
		System.out.println("Testing exists ...");

		String id = "ES";
		
		try {			
			Boolean exists = idiomaService.exists(id);			
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

			List<Idioma> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = idiomaService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					System.out.println("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Idioma cat: results) {
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
		IdiomaServiceTest test = new IdiomaServiceTest();
		test.testFindById();
		test.testExists();
		test.testFindAll();
	}
}



