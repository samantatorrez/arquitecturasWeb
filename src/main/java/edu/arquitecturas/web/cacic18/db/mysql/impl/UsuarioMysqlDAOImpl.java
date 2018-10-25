package edu.arquitecturas.web.cacic18.db.mysql.impl;

import java.util.List;

import javax.persistence.EntityManager;

import edu.arquitecturas.web.cacic18.db.MysqlDao;
import edu.arquitecturas.web.cacic18.db.UsuarioDao;
import edu.arquitecturas.web.cacic18.entity.Usuario;

public class UsuarioMysqlDAOImpl extends MysqlDao implements UsuarioDao{
	
	public void altaUsuario() {
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
		
			Usuario usuario = new Usuario();
			
			eManager.persist(usuario);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}
	
	public Usuario getUsuario(Integer id) {
		Usuario usuario = null;
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			usuario = eManager.find(Usuario.class, id);
			return usuario;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return usuario;
	}
	
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = null;
		EntityManager eManager= null;
		try{
			eManager = getEntityManager();
			usuarios  = eManager.createQuery(
			         "Select a From Employee a", Usuario.class).getResultList();
			return usuarios;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
		return usuarios;
	}
	
	public void bajaUsuario(Integer id) {
		EntityManager eManager=null;
		try{
			eManager = getEntityManager();
			eManager.getTransaction().begin();
		
			Usuario usuario = eManager.find(Usuario.class, id);
			eManager.remove(usuario);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}finally{
			eManager.close();
		}
	}
	
}
