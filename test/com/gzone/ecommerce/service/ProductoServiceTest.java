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

	protected void testFindById() {
		logger.info("Testing findById ...");
		
		Long id = (long) 19;
		String idioma = "ES";
		
		try {			
			Producto pro = productoService.findById(id,idioma);	
			for (Idioma idim : pro.getIdioma())
			{
				System.out.println(idim.getNombreIdioma());
			}
			for (NJugadores nj : pro.getNjugadores())
			{
				System.out.println(nj.getnJugadores());
			}
			for (Categoria cat : pro.getCategorias())
			{
				System.out.println(cat.getCategoria());
			}
			logger.info("Found: "+ToStringUtil.toString(pro));
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test testFindById finished.\n");		
	}
	
	protected void testFindAll() {
		logger.info("Testing findAll ...");
		
		int pageSize = 2; 	
		String idioma = "ES";
		try {

			List<Producto> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = productoService.findAll(startIndex, pageSize,idioma);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Producto pro: results) {
						total++;
						for (Idioma idim : pro.getIdioma())
						{
							System.out.println(idim.getNombreIdioma());
						}
						for (NJugadores nj : pro.getNjugadores())
						{
							System.out.println(nj.getnJugadores());
						}
						for (Categoria cat : pro.getCategorias())
						{
							System.out.println(cat.getCategoria());
						}
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
		int pageSize = 12;
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		Categoria e = new Categoria();
		e.setIdCategoria(1L);
		categorias.add(e);
		Categoria i = new Categoria();
		i.setIdCategoria(6L);
		categorias.add(i);
		
		List<Idioma> idiomas = new ArrayList<Idioma>();
		Idioma a = new Idioma();
		a.setIdIdioma("'ES'");
		idiomas.add(a);
		Idioma o = new Idioma();
		o.setIdIdioma("'KR'");
		idiomas.add(o);
		
		List<NJugadores> njugadores = new ArrayList<NJugadores>();
		NJugadores nj = new NJugadores();
		nj.setIdNJugadores(1L);
		njugadores.add(nj);
		NJugadores nj2 = new NJugadores();
		nj2.setIdNJugadores(3L);
		njugadores.add(nj2);
		
		
		ProductoCriteria p = new ProductoCriteria();
//		p.setNombre("res");
//		p.setCategorias(categorias);
//		p.setIdioma(idiomas);
//		p.setNjugadores(njugadores);
		p.setOferta(2L);
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
						for(Idioma idioma: t.getIdioma())
						{
							idioma.getIdIdioma();
						}
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

	public static void main(String args[]) {
		ProductoServiceTest test = new ProductoServiceTest();
//		test.testExists();
//		test.testFindById();
//		test.testFindAll();
		test.testFindByCriteria();
//		test.testCreate();
//		test.testUpdate();
//		test.testDelete();
		
	}
}



