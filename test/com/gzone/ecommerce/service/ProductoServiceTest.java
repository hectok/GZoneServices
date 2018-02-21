package com.gzone.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Categoria;
import com.gzone.ecommerce.model.Idioma;
import com.gzone.ecommerce.model.NJugadores;
import com.gzone.ecommerce.model.Producto;
import com.gzone.ecommerce.service.impl.ProductoServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;


public class ProductoServiceTest {
	
	private static Logger logger = LogManager.getLogger(ProductoServiceTest.class.getName());

	private ProductoService productoService = null;
	
	public ProductoServiceTest() {
		productoService = new ProductoServiceImpl();
	}
	
	
	protected void testExists() {
		logger.info("Test de existencia de productos ...");

		Long id = (long) 1;
		
		try {			
			Boolean exists = productoService.exists(id);			
			logger.info("Exists: "+id+" -> "+exists);
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test exists finished.\n");		
	}
	
	protected void testFindById() {
		logger.info("Testing findById ...");
		
		Long id = (long) 1;
		String idioma = "'ES'";
		
		try {			
			Producto pro = productoService.findById(id,idioma);			
			logger.info("Found: "+ToStringUtil.toString(pro));
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test testFindById finished.\n");		
	}
	
	protected void testFindAll() {
		logger.info("Testing findAll ...");
		
		int pageSize = 2; 	
		
		try {

			List<Producto> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = productoService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Producto pro: results) {
						total++;
						logger.info("Result "+total+": "+ToStringUtil.toString(pro));
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
	
	protected void testFindByCriteria() {
		logger.info("Testing FindByCriteria ...");
		int pageSize = 2;
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		Categoria e = new Categoria();
		e.setIdCategoria(22L);
		categorias.add(e);
		Categoria i = new Categoria();
		i.setIdCategoria(6L);
		categorias.add(i);
		
		List<Idioma> idiomas = new ArrayList<Idioma>();
		Idioma a = new Idioma();
		a.setIdIdioma("'ES'");
		idiomas.add(a);
		Idioma o = new Idioma();
		o.setIdIdioma("'EN'");
		idiomas.add(o);
		
		List<NJugadores> njugadores = new ArrayList<NJugadores>();
		NJugadores nj = new NJugadores();
		nj.setIdNJugadores(1L);
		njugadores.add(nj);
		NJugadores nj2 = new NJugadores();
		nj2.setIdNJugadores(3L);
		njugadores.add(nj2);
		
		
		ProductoCriteria p = new ProductoCriteria();
		p.setNombre("res");
		p.setCategorias(categorias);
		p.setIdioma(idiomas);
		p.setNjugadores(njugadores);
		
		try {

			List<Producto> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = productoService.findByCriteria(p, startIndex, pageSize,"ES");
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
			logger.error("id = "+p.getIdProducto(), t);
		}
		logger.info("Test FindByCriteria finished.\n");
	}

	
	protected void testCreate() {		
		logger.info("Testing create ...");	
		
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
			
			logger.info("Created: "+ToStringUtil.toString(producto));
					
		} catch (Throwable t) {
			logger.error("id = "+producto.getIdProducto(), t);
		}
		logger.info("Test created finished.\n");		
	}
	
	
	protected void testUpdate() {		
		logger.info("Testing update ...");	
		
		try {
			ProductoCriteria producto = new ProductoCriteria();
			producto.setNombre("Grand Theft Auto 5");
			List<Producto> results = 
					productoService.findByCriteria(producto, 1, 10,"ES");
			if (results.size()<1) {
				throw new RuntimeException("Unexpected results count from previous tests: "+results.size());
			}
			Producto pro = results.get(0);
			pro.setNombre("Grand Theft Auto V");

			productoService.update(pro);

			producto = new ProductoCriteria();
			producto.setIdProducto(pro.getIdProducto());
			
			pro = productoService.findByCriteria(producto, 1, 10,"ES").get(0);
			
			logger.info("Updated to: "+pro.getNombre());
								
		} catch (Throwable t) {
			logger.error(t);
		}
		logger.info("Test update finished.\n");		
	}	
	
	/**
	 * 
	 */
	protected void testDelete() {		
		logger.info("Testing delete ...");	
			
		try {
			ProductoCriteria productoCriteria = new ProductoCriteria();
			productoCriteria.setNombre("Grand Theft Auto V");

			List<Producto> results = 
					productoService.findByCriteria(productoCriteria, 1, 10,"ES");
			if (results.size()!=1) {
				throw new RuntimeException("Unexpected results from previous test");
			}
			
			Producto producto = results.get(0);
			logger.info("Deleting by id "+producto.getIdProducto());
			productoService.delete(producto.getIdProducto());
			
			productoCriteria = new ProductoCriteria();
			productoCriteria.setIdProducto(producto.getIdProducto());
			
			try {
				producto = productoService.findByCriteria(productoCriteria,1,10,"ES").get(0);
				logger.info("Delete NOK!");
			} catch (InstanceNotFoundException |IndexOutOfBoundsException ine) {
				logger.info("Delete OK");
			}						
								
		} catch (Throwable t) {
			logger.error(t);
		}
		logger.info("Test delete finished.\n");		
	}		
	
	public static void main(String args[]) {
		ProductoServiceTest test = new ProductoServiceTest();
		test.testExists();
		test.testFindById();
		test.testFindAll();
		test.testFindByCriteria();
//		test.testCreate();
//		test.testUpdate();
//		test.testDelete();
		
	}
}



