package edu.arquitecturas.web.cacic18.db.mysql.impl;

import java.util.List;

import javax.persistence.EntityManager;

import edu.arquitecturas.web.cacic18.db.MysqlDao;
import edu.arquitecturas.web.cacic18.db.RevisionDao;
import edu.arquitecturas.web.cacic18.entity.Revision;

public class RevisionMysqlDAOImpl extends MysqlDao implements RevisionDao{

	@Override
	public void altaRevision() {
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
		
			Revision revision = new Revision();
			
			eManager.persist(revision);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}

	@Override
	public Revision getRevision(Integer id) {
		Revision revision = null;
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			revision = eManager.find(Revision.class, id);
			return revision;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return revision;
	}

	@Override
	public List<Revision> getRevisiones() {
		List<Revision> revisiones = null;
		EntityManager eManager = null;
		try {
			eManager = getEntityManager();
			revisiones = eManager.createQuery(
			         "Select a From Employee a", Revision.class).getResultList();
			return revisiones;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return revisiones;
	}

	@Override
	public void bajaRevision(Integer id) {
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
		
			Revision revision = eManager.find(Revision.class, id);
			eManager.remove(revision);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}
	
}
