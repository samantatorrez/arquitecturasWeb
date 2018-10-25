package edu.arquitecturas.web.cacic2018;

import org.junit.Test;

import edu.arquitecturas.web.cacic18.db.DAOFactory;
import edu.arquitecturas.web.cacic18.db.UsuarioDao;
import edu.arquitecturas.web.cacic18.entity.Usuario;
import junit.framework.TestCase;

public class AppTestCase extends TestCase {
	@Test
	public void testGetUser() {
		DAOFactory factory = new DAOFactory();
		UsuarioDao usuarioDao = factory.getUsuarioDao("MYSQL");
    	for(int i=0; i<10; i++) {
    		usuarioDao.altaUsuario();
    	}
    	Usuario usuario = usuarioDao.getUsuario(1);
    	System.out.println(usuario.getNombre());
	}
}
