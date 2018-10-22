package edu.arquitecturas.web.cacic2018.db;

import java.util.List;

import edu.arquitecturas.web.cacic2018.entity.Trabajo;

public interface TrabajoDao {
	public void altaTrabajo();
	public Trabajo getTrabajo(Integer id);
	public List<Trabajo> getTrabajos();
	public void bajaTrabajo(Integer id);
}
