package com.gzone.ecommercer.service;


import java.util.List;

import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Producto;
import com.gzone.ecommerce.service.ProductoCriteria;
import com.gzone.ecommerce.service.ProductoService;
import com.gzone.ecommerce.service.impl.ProductoServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;


public class ProductoServiceTest {
	
	private ProductoService productoService = null;
	
	public ProductoServiceTest() {
		productoService = new ProductoServiceImpl();
	}
	
	
	protected void testExists() {
		System.out.println("Test de existencia de productos ...");

		Integer id = 1;
		
		try {			
			Boolean exists = productoService.exists(id);			
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

			List<Producto> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = productoService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					System.out.println("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Producto pro: results) {
						total++;
						System.out.println("Result "+total+": "+ToStringUtil.toString(pro));
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
	
	
	protected void testFindById() {
		System.out.println("Testing findById ...");
		
		Integer id = 2;
		
		try {			
			Producto producto = productoService.findById(id);			
			System.out.println("Found: "+ToStringUtil.toString(producto));
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("Test testFindById finished.\n");		
	}
		
	protected void testFindByCriteria() {
		System.out.println("Testing FindByCriteria ...");
		int pageSize = 2;
		
		ProductoCriteria p = new ProductoCriteria();
		p.setNombre("e");

		
		try {

			List<Producto> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = productoService.findByCriteria(p, startIndex, pageSize);
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

	
	protected void testCreate() {		
		System.out.println("Testing create ...");	
		
		Producto producto = new Producto();
		producto.setNombre("Grand Theft Auto 5");
		producto.setPrecio(59.99);
		producto.setAnio(2015);
		producto.setRequisitos( "Requiere un procesador y un sistema operativo de 64 bits\r\n" + 
								"SO: Windows 8.1 de 64 bits, Windows 8 de 64 bits, Windows 7 de 64 bits con Service Pack 1.\r\n" + 
								"Procesador: Intel Core i5 3470 a 3,2 GHz (4 CPU)/AMD X8 FX-8350 a 4 GHz (8 CPU).\r\n" + 
								"Memoria: 8 GB de RAM\r\n" + 
								"Gráficos: NVIDIA GTX 660 2 GB/AMD HD7870 2 GB.\r\n" + 
								"Almacenamiento: 72 GB de espacio disponible\r\n" + 
								"Tarjeta de sonido: compatible con DirectX 10.");
		producto.setOferta(null); 
		try {
			
			producto = productoService.create(producto);
			
			System.out.println("Created: "+ToStringUtil.toString(producto));
					
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test created finished.\n");		
	}
	
	
	protected void testUpdate() {		
		System.out.println("Testing update ...");	
		
		try {
			ProductoCriteria producto = new ProductoCriteria();
			producto.setNombre("Grand Theft Auto 5");
			List<Producto> results = 
					productoService.findByCriteria(producto, 1, 10);
			if (results.size()<1) {
				throw new RuntimeException("Unexpected results count from previous tests: "+results.size());
			}
			
			Producto pro = results.get(0);
			pro.setNombre("Grand Theft Auto V");
			productoService.update(pro);
			
			pro = productoService.findById(pro.getIdProducto());
			
			System.out.println("Updated to: "+pro.getNombre());
								
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test update finished.\n");		
	}	
	
	protected void testDelete() {		
		System.out.println("Testing delete ...");	
			
		try {
			ProductoCriteria productoCriteria = new ProductoCriteria();
			productoCriteria.setNombre("Grand Theft Auto 5");

			List<Producto> results = 
					productoService.findByCriteria(productoCriteria, 1, 10);
			if (results.size()!=1) {
				throw new RuntimeException("Unexpected results from previous test");
			}
			
			Producto producto = results.get(0);
			System.out.println("Deleting by id "+producto.getIdProducto());
			productoService.delete(producto.getIdProducto());
			
			try {
				producto = productoService.findById(producto.getIdProducto());
				System.out.println("Delete NOK!");
			} catch (InstanceNotFoundException ine) {
				System.out.println("Delete OK");
			}						
								
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test delete finished.\n");		
	}		
	
	public static void main(String args[]) {
		ProductoServiceTest test = new ProductoServiceTest();
		test.testExists();
		test.testFindAll();
		test.testFindById();
		test.testFindByCriteria();
		test.testCreate();
		test.testUpdate();
		test.testDelete();
		
	}
}


