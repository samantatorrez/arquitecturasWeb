package edu.arquitecturas.web.cacic18.db;

import edu.arquitecturas.web.cacic18.db.mysql.impl.RevisionMysqlDAOImpl;
import edu.arquitecturas.web.cacic18.db.mysql.impl.TrabajoMysqlDAOImpl;
import edu.arquitecturas.web.cacic18.db.mysql.impl.UsuarioMysqlDAOImpl;

public class DAOFactory 
{
	
	public RevisionDao getRevisionDao(String db) {
		switch(db.toUpperCase()) {
		   case "MYSQL" :
		   default : 
		      return new RevisionMysqlDAOImpl();
		}
	}
	
	public UsuarioDao getUsuarioDao(String db) {
		switch(db.toUpperCase()) {
		   case "MYSQL" :
		   default : 
		      return new UsuarioMysqlDAOImpl();
		}
	}
	
	public TrabajoDao getTrabajoDao(String db) {
		switch(db.toUpperCase()) {
		   case "MYSQL" :
		   default : 
		      return new TrabajoMysqlDAOImpl();
		}
	}
	
}
