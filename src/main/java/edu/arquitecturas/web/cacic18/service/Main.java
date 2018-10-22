package edu.arquitecturas.web.cacic2018.service;

import edu.arquitecturas.web.cacic2018.db.DAOFactory;
import edu.arquitecturas.web.cacic2018.db.UsuarioDao;

public class Main {

	public static void main(String[] args) {
		DAOFactory factory = new DAOFactory();
		UsuarioDao usuarioDao = factory.getUsuarioDao("MYSQL");
		usuarioDao.altaUsuario();
	}

}
