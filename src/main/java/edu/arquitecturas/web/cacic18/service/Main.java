package edu.arquitecturas.web.cacic18.service;

import edu.arquitecturas.web.cacic18.db.DAOFactory;
import edu.arquitecturas.web.cacic18.db.UsuarioDao;

public class Main {

	public static void main(String[] args) {
		DAOFactory factory = new DAOFactory();
		UsuarioDao usuarioDao = factory.getUsuarioDao("MYSQL");
		usuarioDao.altaUsuario();
	}

}
