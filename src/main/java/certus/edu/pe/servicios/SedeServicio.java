package certus.edu.pe.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import certus.edu.pe.modelo.Sede;
import certus.edu.pe.repositorio.SedeRepositorio;
import javax.transaction.Transactional;


@Service
@Transactional
public class SedeServicio {
	@Autowired // Inyección de dependencia
	private SedeRepositorio repositorio;
	
	public SedeServicio() {
		
	}
	
	public List<Sede> buscarTodo(){
		return (List<Sede>) repositorio.findAll();
	}

	public Sede crear(Sede sede) {
		return repositorio.save(sede);
		
	}
	
	public Sede actualizar(Sede SedeActualizar) {
		
		// primero realizamos la búsqueda de películas
		Sede SedeActual = repositorio.findById(SedeActualizar.getIdSede()).get();
		
		SedeActual.setIdSede(SedeActualizar.getIdSede());
		SedeActual.setNombre(SedeActualizar.getNombre());
		SedeActual.setDireccion(SedeActualizar.getDireccion());
		SedeActual.setCategoria(SedeActualizar.getCategoria());
		SedeActual.setCine(SedeActualizar.getCine());
		
		
		Sede SedeActualizado = repositorio.save(SedeActual);
		return SedeActualizado;
	}
	
	public Sede buscarPorId(Integer id) {
		
		return repositorio.findById(id).get();
		
	}
	
	public void borrarPorId(Integer id) {
		
		repositorio.deleteById(id);
	}

}
