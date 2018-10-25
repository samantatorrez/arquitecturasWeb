package edu.arquitecturas.web.cacic18.db;

import java.util.List;

import edu.arquitecturas.web.cacic18.entity.Usuario;

public interface UsuarioDao {
	
	public void altaUsuario();
	public Usuario getUsuario(Integer id);
	public List<Usuario> getUsuarios();
	public void bajaUsuario(Integer id);
	
}
