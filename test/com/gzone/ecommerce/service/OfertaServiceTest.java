package com.gzone.ecommerce.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Oferta;
import com.gzone.ecommerce.service.impl.OfertaServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;


public class OfertaServiceTest {
	
	private static Logger logger = LogManager.getLogger(OfertaServiceTest.class.getName());

	private OfertaService ofertaService = null;
	
	public OfertaServiceTest() {
		ofertaService = new OfertaServiceImpl();
	}
	
	
	protected void testExists() {
		logger.info("Test de existencia de oferta ...");

		Long id = (long) 1;
		
		try {			
			Boolean exists = ofertaService.exists(id);			
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

			List<Oferta> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = ofertaService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Oferta o: results) {
						total++;
						logger.info("Result "+total+": "+ToStringUtil.toString(o));
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
		
		OfertaCriteria o = new OfertaCriteria();
		o.setPrecio(0.5);

		try {

			List<Oferta> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = ofertaService.findByCriteria(o, startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Oferta t: results) {
						total++;
						logger.info("Result "+total+": "+ToStringUtil.toString(t));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			logger.info("Found "+total+" results.");
						
		} catch (Throwable t) {
			logger.error("id = "+o.getIdOferta(), t);
		}
		logger.info("Test FindByCriteria finished.\n");
	}

	
	protected void testCreate() {		
		logger.info("Testing create ...");	
		Date localDate = new Date();
		
		Oferta oferta = new Oferta();
		oferta.setFechaCreacion(localDate);
		oferta.setPrecio(0.70);
		
		try {
			
			oferta = ofertaService.create(oferta);
			
			logger.info("Created: "+ToStringUtil.toString(oferta));
					
		} catch (Throwable t) {
			logger.error("id = "+oferta.getIdOferta(), t);
		}
		logger.info("Test created finished.\n");		
	}
	
	
	protected void testUpdate() {		
		logger.info("Testing update ...");	
		
		try {
			OfertaCriteria oferta = new OfertaCriteria();
			oferta.setPrecio(0.70);
			List<Oferta> results = 
					ofertaService.findByCriteria(oferta, 1, 10);
			if (results.size()<1) {
				throw new RuntimeException("Unexpected results count from previous tests: "+results.size());
			}
			Oferta o = results.get(0);
			o.setPrecio(0.80);

			ofertaService.update(o);

			oferta = new OfertaCriteria();
			oferta.setIdOferta(o.getIdOferta());
			
			o = ofertaService.findByCriteria(oferta, 1, 10).get(0);
			
			logger.info("Updated to: "+o.getPrecio());
								
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
			OfertaCriteria ofertaCriteria = new OfertaCriteria();
			ofertaCriteria.setPrecio(0.80);

			List<Oferta> results = 
					ofertaService.findByCriteria(ofertaCriteria, 1, 10);
			if (results.size()!=1) {
				throw new RuntimeException("Unexpected results from previous test");
			}
			
			Oferta oferta = results.get(0);
			
			logger.info("Deleting by id "+oferta.getIdOferta());
			ofertaService.delete(oferta.getIdOferta());
			
			ofertaCriteria = new OfertaCriteria();
			ofertaCriteria.setIdOferta(oferta.getIdOferta());
			
			try {
				oferta = ofertaService.findByCriteria(ofertaCriteria,0,0).get(0);
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
		OfertaServiceTest test = new OfertaServiceTest();
		test.testExists();
		test.testFindAll();
		test.testFindByCriteria();
//		test.testCreate();
//		test.testUpdate();
//		test.testDelete();
		
	}
}



