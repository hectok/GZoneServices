package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Usuario;
import com.gzone.ecommerce.service.UsuarioCriteria;
import com.gzone.ecommerce.service.UsuarioService;
import com.gzone.ecommerce.service.impl.UsuarioServiceImpl;
import com.gzone.ecommerce.util.ToStringUtil;


public class UsuarioServiceTest {
	
	private UsuarioService usuarioService = null;
	
	public UsuarioServiceTest() {
		usuarioService = new UsuarioServiceImpl();
	}
	
	
	protected void testExists() {
		System.out.println("Test de existencia de usuarios ...");

		Long id = (long) 1;
		
		try {			
			Boolean exists = usuarioService.exists(id);			
			System.out.println("Exists: "+id+" -> "+exists);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		System.out.println("Test exists finished.\n");		
	}

	protected void testFindByCriteria() {
		System.out.println("Testing FindByCriteria ...");
		int pageSize = 2;
		
		UsuarioCriteria p = new UsuarioCriteria();
		p.setUsuario("jalp");
	
		try {

			List<Usuario> results = null;
			int startIndex = 1; 
			int total = 0;
			
			do {
				results = usuarioService.findByCriteria(p, startIndex, pageSize);
				if (results.size()>0) {
					System.out.println("Page ["+startIndex+" - "+(startIndex+results.size()-1)+"] : ");				
					for (Usuario t: results) {
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
		
		Usuario usuario = new Usuario();
		usuario.setUsuario("laRubiade2");
		usuario.setCorreo("lalocadesegundo@gmail.com");
		usuario.setContrasena("yasabeisquiendigo");

		try {
			
			usuario = usuarioService.create(usuario);
			
			System.out.println("Created: "+ToStringUtil.toString(usuario));
					
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test created finished.\n");		
	}
	
	
	protected void testUpdate() {		
		System.out.println("Testing update ...");	
		
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
			usuarioUpdate.setApellido("Ledo Doval");
			usuarioUpdate.setDescripcion("Orgulloso creador de GZone");
			usuarioUpdate.setLocalizacion(null);

			usuarioService.update(usuarioUpdate);

			usuario = new UsuarioCriteria();
			usuario.setIdUsuario(usuarioUpdate.getIdUsuario());
			
			usuarioUpdate = usuarioService.findByCriteria(usuario, 1, 10).get(0);
			
			System.out.println("Updated to: "+usuarioUpdate.getUsuario());
								
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test update finished.\n");		
	}	
	
	/**
	 * 
	 */
	protected void testDelete() {		
		System.out.println("Testing delete ...");	
			
		try {
			UsuarioCriteria usuarioCriteria = new UsuarioCriteria();
			usuarioCriteria.setUsuario("laRubiade2");

			List<Usuario> results = 
					usuarioService.findByCriteria(usuarioCriteria, 1, 10);
			if (results.size()!=1) {
				throw new RuntimeException("Unexpected results from previous test");
			}
			
			Usuario usuario = results.get(0);
			System.out.println("Deleting by id "+usuario.getIdUsuario());
			usuarioService.delete(usuario.getIdUsuario());
			
			usuarioCriteria = new UsuarioCriteria();
			usuarioCriteria.setIdUsuario(usuario.getIdUsuario());
			
			try {
				usuario = usuarioService.findByCriteria(usuarioCriteria,1,10).get(0);
				System.out.println("Delete NOK!");
			} catch (InstanceNotFoundException |IndexOutOfBoundsException ine) {
				System.out.println("Delete OK");
			}						
								
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.out.println("Test delete finished.\n");		
	}		
	
	public static void main(String args[]) {
		UsuarioServiceTest test = new UsuarioServiceTest();
		test.testCreate();
		test.testExists();
		test.testFindByCriteria();
		test.testUpdate();
		test.testDelete();
		
	}
}



