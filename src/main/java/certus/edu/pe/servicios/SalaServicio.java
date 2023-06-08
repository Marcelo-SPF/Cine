package certus.edu.pe.servicios;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import certus.edu.pe.modelo.Sala;
import certus.edu.pe.repositorio.SalaRepositorio;
import certus.edu.pe.repositorio.SalaRepositorio;
import javax.transaction.Transactional;

@Service
@Transactional
public class SalaServicio {
	@Autowired // Inyección de dependencia
	public SalaRepositorio SalaRepositorio;
	
	public SalaServicio() {
			
	}
	
	public List<Sala> buscarTodo(){
		return (ArrayList<Sala>) SalaRepositorio.findAll();

	}
	
	public Sala buscarPorId(Integer id) {
		return SalaRepositorio.findById(id).get();
	}
	
	public Sala crear(Sala Sala) {
		return SalaRepositorio.save(Sala); // Registra una función en BD
	}
	
	public Sala actualizar (Sala funcionActualizar) {
		Sala funcionActual = SalaRepositorio.findById(funcionActualizar.getIdSala()).get();
		funcionActual.setIdSala(funcionActualizar.getIdSala());
		funcionActual.setNombre(funcionActualizar.getNombre());
		funcionActual.setCapacidad(funcionActualizar.getCapacidad());
		funcionActual.setSede(funcionActualizar.getSede());
		
		Sala SalaActualizado= SalaRepositorio.save(funcionActual); // Actualiza en BD
		return SalaActualizado;
		
	}
	
	public void eliminarSala(Integer id) {
		SalaRepositorio.deleteById(id);
		
	}
	
	public void actualizar(int id, Sala funcion) {
		
		Sala funcionActual = SalaRepositorio.findById(id).get();
		
		funcionActual.setIdSala(funcion.getIdSala());
		funcionActual.setNombre(funcion.getNombre());
		funcionActual.setCapacidad(funcion.getCapacidad());
		funcionActual.setSede(funcion.getSede()); // Aquí trae los datos de la entidad Película
		//funcionActual.setSala(funcion.getSala());// Aquí trae los datos de la entidad Sala
		
		SalaRepositorio.save(funcionActual);
		
		
	}

}
