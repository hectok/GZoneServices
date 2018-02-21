package com.gzone.ecommerce.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.LineaTicket;
import com.gzone.ecommerce.model.Ticket;
import com.gzone.ecommerce.service.impl.TicketServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;

public class TicketServiceTest {
	
	private static Logger logger = LogManager.getLogger(TicketServiceTest.class.getName());
	
	private TicketService ticketService = null;
	
	public TicketServiceTest() {
		ticketService = new TicketServiceImpl();
	}
	
	protected void testFindById() {
		logger.info("Testing findById ...");
				Long id = 2L;
		
		try {			
			Ticket p = ticketService.findById(id);			
			logger.info("Found: "+ToStringUtil.toString(p));
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test testFindById finished.\n");		
	}
	
	protected void testExists() {
		logger.info("Testing exists ...");
				Long id = 2L;
		
		try {			
			Boolean exists = ticketService.exists(id);			
			logger.info("Exists: "+id+" -> "+exists);
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test exists finished.\n");		
	}
	
	protected void testFindAll() {
		logger.info("Testing findAll ...");
		int pageSize = 10; 	
		
		try {

			List<Ticket> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = ticketService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Ticket p: results) {
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
	
	
	protected void testFindByCriteria() {
		logger.info("Testing FindByCriteria ...");
		int pageSize = 2;
		
		TicketCriteria tc = new TicketCriteria();
		tc.setCodCompra(2L);
		
		try {

			List<Ticket> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = ticketService.findByCriteria(tc, startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Ticket p: results) {
						total++;
						logger.info("Result "+total+": "+ToStringUtil.toString(p));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			logger.info("Found "+total+" results.");
						
		} catch (Throwable t) {
			logger.error("id = "+tc.getCodCompra(), t);
		}
		logger.info("Test FindByCriteria finished.\n");
	}
	
	protected void testCreate() {		
		logger.info("Testing create ...");
		Date localDate = new Date();

		try {
			
			LineaTicket lineaTicket1 = new LineaTicket();
			lineaTicket1.setIdProducto(1L);
			lineaTicket1.setPrecio(19.99);
			
			LineaTicket lineaTicket2 = new LineaTicket();
			lineaTicket2.setIdProducto(2L);
			lineaTicket2.setPrecio(29.99);
			
			List<LineaTicket> lista = new ArrayList<LineaTicket>();
			lista.add(lineaTicket1);
			lista.add(lineaTicket2);
			
			Ticket t = new Ticket();
			t.setCantidad(1L);
			t.setFechaTicket(localDate);
			t.setDirFacturacion("A mi casa");
			t.setId_usuario(1L);
			t.setLineas(lista);
			
			t = ticketService.create(t);
			
			logger.info("Created: "+ToStringUtil.toString(t));
					
		} catch (Throwable t) {
			logger.error(t);
		}
		logger.info("Test created finished.\n");		
	}
	
	protected void testUpdate() {		
		logger.info("Testing update ...");	
				
		try {
			
			TicketCriteria ticketCriteria = new TicketCriteria();
			ticketCriteria.setCodCompra(2L);

			List<Ticket> results = 
					ticketService.findByCriteria(ticketCriteria, 1, 10);
			if (results.size()<1) {
				throw new RuntimeException("Unexpected results count from previous tests: "+results.size());
			}
			
			Ticket p = results.get(0);
			p.setCantidad(1L);
			p.setFechaTicket(new SimpleDateFormat( "yyyyMMdd" ).parse( "20180130" ));
			p.setDirFacturacion("Centulle");
			p.setId_usuario(1L);			
						
			ticketService.update(p);
			
			p = ticketService.findById(p.getCodCompra());
			
			logger.info("Updated to: "+p.getFechaTicket());
								
		} catch (Throwable t) {
			logger.error(t);
		}
		logger.info("Test update finished.\n");		
	}	
	
	protected void testDelete() {		
		logger.info("Testing delete ...");	
		
		try {

			TicketCriteria ticketCriteria = new TicketCriteria();
			ticketCriteria.setCodCompra(26L);

			List<Ticket> results = 
					ticketService.findByCriteria(ticketCriteria, 1, 10);
			if (results.size()<1) {
				throw new RuntimeException("Unexpected results count from previous tests: "+results.size());
			}
			
			Ticket p = results.get(0);
			logger.info("Deleting by id "+ p.getCodCompra());
			ticketService.delete(p.getCodCompra());	
			try {
				p = ticketService.findById(p.getCodCompra());
				logger.info("Delete NOK!");
			} catch (InstanceNotFoundException ine) {
				logger.info("Delete OK");
			}						
								
		} catch (Throwable t) {
			logger.error(t);
		}
		logger.info("Test delete finished.\n");		
	}		
	
	public static void main(String args[]) {
		TicketServiceTest test = new TicketServiceTest();
		//test.testCreate();
		test.testFindById();	
		test.testExists();
		test.testFindAll();	
		test.testFindByCriteria();
		test.testUpdate();
		//test.testDelete();
	}

}
