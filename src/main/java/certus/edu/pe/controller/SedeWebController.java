package certus.edu.pe.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import certus.edu.pe.modelo.Sede;
import certus.edu.pe.servicios.SedeServicio;

@Controller
@RequestMapping("/sedess")
public class SedeWebController {
	
	@Autowired // inyeccción de dependencia
	private SedeServicio servicio;
	
	@RequestMapping("/listarTodo2")
	public String listaSedes(Model model) {
		List<Sede> listaSedes = servicio.buscarTodo();
		
		System.out.println("LISTA DE SEDES : " + listaSedes);
		
		model.addAttribute("listaSedes", listaSedes);
		return "/moduloSedes/listarTodo2";
	}
	

	@RequestMapping("/nuevo")
	public String nuevaPelicula(Model model) {
		Sede sede = new Sede();
		model.addAttribute("sede", sede);
		return "/moduloSedes/nuevaSede2";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearSede(@ModelAttribute("sede") Sede sede) {
		    servicio.crear(sede);
		    return "redirect:/sedess/listarTodo2";
	
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarSede(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloSedes/editarSede2");
	    Sede sede = servicio.buscarPorId(id);
	    mav.addObject("sede", sede);
	    return mav;
	}
	
	
	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarSede(@PathVariable(name = "id") int id) {
		  servicio.borrarPorId(id);
		 return "redirect:/sedess/listarTodo2";
		
	}	
	
	

}
