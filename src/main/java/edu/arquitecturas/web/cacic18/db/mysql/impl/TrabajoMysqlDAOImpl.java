package edu.arquitecturas.web.cacic18.db.mysql.impl;

import java.util.List;

import javax.persistence.EntityManager;

import edu.arquitecturas.web.cacic18.db.MysqlDao;
import edu.arquitecturas.web.cacic18.db.TrabajoDao;
import edu.arquitecturas.web.cacic18.entity.Trabajo;

public class TrabajoMysqlDAOImpl extends MysqlDao implements TrabajoDao{
	
	public void altaTrabajo() {
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
		
			Trabajo trabajo = new Trabajo();
			
			eManager.persist(trabajo);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}
	
	public Trabajo getTrabajo(Integer id) {
		Trabajo trabajo = null;
		EntityManager eManager = null;
		try{
			eManager = getEntityManager();
			trabajo = eManager.find(Trabajo.class, id);
			return trabajo;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return trabajo;
	}
	
	public List<Trabajo> getTrabajos() {
		List<Trabajo> trabajos = null;
		EntityManager eManager = null;
		try{
			eManager = getEntityManager();
			trabajos = eManager.createQuery(
			         "Select a From Employee a", Trabajo.class).getResultList();
			return trabajos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return trabajos;
	}
	
	public void bajaTrabajo(Integer id) {
		EntityManager eManager = null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
		
			Trabajo trabajo = eManager.find(Trabajo.class, id);
			eManager.remove(trabajo);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}
	
}
