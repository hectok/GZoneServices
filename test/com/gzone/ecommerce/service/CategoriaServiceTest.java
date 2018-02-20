/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import com.gzone.ecommerce.model.Categoria;
import com.gzone.ecommerce.model.Producto;
import com.gzone.ecommerce.service.impl.CategoriaServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;

/**
 * @author hector.ledo.doval
 *
 */
public class CategoriaServiceTest {

	private CategoriaService categoriaService = null;
	
	public CategoriaServiceTest() {
		categoriaService = new CategoriaServiceImpl();
	}
	
	protected void testFindById() {
		System.out.println("Testing findById ...");
		
		Long id = (long) 1;
		
		try {			
			Categoria cat = categoriaService.findById(id);			
			System.out.println("Found: "+ToStringUtil.toString(cat));
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("Test testFindById finished.\n");		
	}
	
	protected void testExists() {
		System.out.println("Testing exists ...");

		Long id = (long) 1;
		
		try {			
			Boolean exists = categoriaService.exists(id);			
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

			List<Categoria> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = categoriaService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					System.out.println("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Categoria cat: results) {
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
	
	protected void testFindByProducto() {
		System.out.println("Testing findByCategoria ...");
		
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
					System.out.println("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Producto t: results) {
						total++;
						System.out.println("Result "+total+": "+ToStringUtil.toString(t));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			System.out.println("Found "+total+" results.");
						
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test FindByCriteria finished.\n");
	}
	
	public static void main(String args[]) {
		CategoriaServiceTest test = new CategoriaServiceTest();
//		test.testFindById();
//		test.testExists();
//		test.testFindAll();
		test.testFindByProducto();	
	}
}

