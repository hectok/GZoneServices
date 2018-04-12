package com.gzone.ecommerce.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Usuario;
import com.gzone.ecommerce.service.UsuarioCriteria;
import com.gzone.ecommerce.service.UsuarioService;
import com.gzone.ecommerce.service.impl.UsuarioServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;


public class UsuarioServiceTest {
	
	private static Logger logger = LogManager.getLogger(UsuarioServiceTest.class.getName());

	private UsuarioService usuarioService = null;
	
	public UsuarioServiceTest() {
		usuarioService = new UsuarioServiceImpl();
	}
	
	
	protected void testExists() {
		logger.info("Test de existencia de usuarios ...");

		Long id = (long) 1;
		
		try {			
			Boolean exists = usuarioService.exists(id);			
			logger.info("Exists: "+id+" -> "+exists);
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test exists finished.\n");		
	}
	
	protected void testFindById() {
		logger.info("Testing findById ...");
		
		Long id = (long) 9;
		
		try {			
			Usuario usuario = usuarioService.findById(id);			
			logger.info("Found: "+ToStringUtil.toString(usuario));
			
		} catch (Throwable t) {
			logger.error("id = "+id, t);
		}
		
		logger.info("Test testFindById finished.\n");		
	}
	
	protected void testFindByNombre() {
		logger.info("Testing findByNombre ...");
		
		String nombre = "hectok";
		
		try {			
			Usuario usuario = usuarioService.findByNombre(nombre);			
			logger.info("Found: "+ToStringUtil.toString(usuario));
		} catch (Throwable t) {
			logger.error("id = "+nombre, t);
		}
		
		logger.info("Test testFindById finished.\n");		
	}
	
	protected void testFindByCriteria() {
		logger.info("Testing FindByCriteria ...");
		int pageSize = 2;
		
		UsuarioCriteria p = new UsuarioCriteria();
		p.setUsuario("hectok");
	
		try {

			List<Usuario> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = usuarioService.findByCriteria(p, startIndex, pageSize);
				if (results.size()>0) {
					logger.info("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Usuario t: results) {
						total++;
						logger.info("Result "+total+": "+ToStringUtil.toString(t));
					}
					startIndex = startIndex + pageSize;
				}
				
			} while (results.size()==pageSize);
			
			logger.info("Found "+total+" results.");
						
		} catch (Throwable t) {
			logger.error(t);
		}
		logger.info("Test FindByCriteria finished.\n");
	}

	
	protected void testCreate() {		
		logger.info("Testing create ...");	
		
		Usuario usuario = new Usuario();
		usuario.setUsuario("joseantoniolp");
		usuario.setCorreo("joseantoniokp@gmail.com");
		usuario.setContrasena("abc.,123");

		try {
			
			usuario = usuarioService.create(usuario);
			
			logger.info("Created: "+ToStringUtil.toString(usuario));
					
		} catch (Throwable t) {
			logger.error("id = "+usuario.getIdUsuario(), t);
		}
		logger.info("Test created finished.\n");		
	}
	
	
	protected void testUpdate() {		
		logger.info("Testing update ...");	
		
		try {
			UsuarioCriteria usuario = new UsuarioCriteria();
			usuario.setUsuario("hectok");
			List<Usuario> results = 
					usuarioService.findByCriteria(usuario, 1, 10);
			if (results.size()<1) {
				throw new RuntimeException("Unexpected results count from previous tests: "+results.size());
			}
			Usuario usuarioUpdate = results.get(0);
			usuarioUpdate.setNombre("Hector");
//			usuarioUpdate.setApellido("Ledo Doval");
//			usuarioUpdate.setDescripcion("Soy el administrador de GZone");
			usuarioUpdate.setLocalizacion(null);

			usuarioService.update(usuarioUpdate);

			usuario = new UsuarioCriteria();
			usuario.setIdUsuario(usuarioUpdate.getIdUsuario());
			
			usuarioUpdate = usuarioService.findByCriteria(usuario, 1, 10).get(0);
			
			logger.info("Updated to: "+usuarioUpdate.getUsuario());
								
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
			UsuarioCriteria usuarioCriteria = new UsuarioCriteria();
			usuarioCriteria.setUsuario("joseantoniolp");

			List<Usuario> results = 
					usuarioService.findByCriteria(usuarioCriteria, 1, 10);
			if (results.size()!=1) {
				throw new RuntimeException("Unexpected results from previous test");
			}
			
			Usuario usuario = results.get(0);
			logger.info("Deleting by id "+usuario.getIdUsuario());
			usuarioService.delete(usuario.getIdUsuario());
			
			usuarioCriteria = new UsuarioCriteria();
			usuarioCriteria.setIdUsuario(usuario.getIdUsuario());
			
			try {
				usuario = usuarioService.findByCriteria(usuarioCriteria,1,10).get(0);
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
		UsuarioServiceTest test = new UsuarioServiceTest();
//		test.testCreate();
//		test.testExists();
//		test.testFindById();
//		test.testFindByNombre();
//		test.testFindByCriteria();
		test.testUpdate();
//		test.testDelete();
		
	}
}



