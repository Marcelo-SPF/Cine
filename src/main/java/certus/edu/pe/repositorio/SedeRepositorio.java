package certus.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import certus.edu.pe.modelo.Sede;
public interface SedeRepositorio extends CrudRepository<Sede, Integer>{
	
	@Query(value = "SELECT a FROM Sede a WHERE a.nombre =?1")
	public List<Sede> buscarSedesPorNombre(String nombre);
	
	
	@Query(value = "SELECT a FROM Sede a WHERE a.nombre like CONCAT(?1, '%')")
	public List<Sede> buscarSedeLikeNombre(String nombre);

}
