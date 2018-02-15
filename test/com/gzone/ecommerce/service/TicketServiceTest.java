package com.gzone.ecommerce.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.LineaTicket;
import com.gzone.ecommerce.model.Ticket;
import com.gzone.ecommerce.service.impl.TicketServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;

public class TicketServiceTest {
	
	private TicketService ticketService = null;
	
	public TicketServiceTest() {
		ticketService = new TicketServiceImpl();
	}
	
	protected void testFindById() {
		System.out.println("Testing findById ...");
				Long id = 26L;
		
		try {			
			Ticket p = ticketService.findById(id);			
			System.out.println("Found: "+ToStringUtil.toString(p));
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("Test testFindById finished.\n");		
	}
	
	protected void testExists() {
		System.out.println("Testing exists ...");
				Long id = 26L;
		
		try {			
			Boolean exists = ticketService.exists(id);			
			System.out.println("Exists: "+id+" -> "+exists);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("Test exists finished.\n");		
	}
	
	protected void testFindAll() {
		System.out.println("Testing findAll ...");
		int pageSize = 10; 	
		
		try {

			List<Ticket> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = ticketService.findAll(startIndex, pageSize);
				if (results.size()>0) {
					System.out.println("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Ticket p: results) {
						total++;
						System.out.println("Result "+total+": "+ToStringUtil.toString(p));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			System.out.println("Found "+total+" results.");
						
		} catch (Throwable c) {
			c.printStackTrace();
		}
		System.out.println("Test testFindAll finished.\n");
	}
	
	
	protected void testFindByCriteria() {
		System.out.println("Testing FindByCriteria ...");
		int pageSize = 2;
		
		TicketCriteria tc = new TicketCriteria();
		tc.setCodCompra(26L);
		
		try {

			List<Ticket> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = ticketService.findByCriteria(tc, startIndex, pageSize);
				if (results.size()>0) {
					System.out.println("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Ticket p: results) {
						total++;
						System.out.println("Result "+total+": "+ToStringUtil.toString(p));
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
			
			System.out.println("Created: "+ToStringUtil.toString(t));
					
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test created finished.\n");		
	}
	
	protected void testUpdate() {		
		System.out.println("Testing update ...");	
				
		try {
			
			TicketCriteria ticketCriteria = new TicketCriteria();
			ticketCriteria.setCodCompra(26L);

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
			
			System.out.println("Updated to: "+p.getFechaTicket());
								
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test update finished.\n");		
	}	
	
	protected void testDelete() {		
		System.out.println("Testing delete ...");	
		
		try {

			TicketCriteria ticketCriteria = new TicketCriteria();
			ticketCriteria.setCodCompra(26L);

			List<Ticket> results = 
					ticketService.findByCriteria(ticketCriteria, 1, 10);
			if (results.size()<1) {
				throw new RuntimeException("Unexpected results count from previous tests: "+results.size());
			}
			
			Ticket p = results.get(0);
			System.out.println("Deleting by id "+ p.getCodCompra());
			ticketService.delete(p.getCodCompra());	
			try {
				p = ticketService.findById(p.getCodCompra());
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
		TicketServiceTest test = new TicketServiceTest();
		test.testCreate();
		test.testFindById();	
		test.testExists();
		test.testFindAll();	
		test.testFindByCriteria();
		test.testUpdate();
		test.testDelete();
	}

}
