package ifrn.PI.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.PI.eventos.models.Convidado;
import ifrn.PI.eventos.models.Evento;
import ifrn.PI.eventos.repositories.ConvidadoRepository;
import ifrn.PI.eventos.repositories.EventosRepository;
import org.springframework.stereotype.*;
import org.springframework.stereotype.*;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventosRepository er;
	@Autowired
	private ConvidadoRepository cr;

	@GetMapping("/form")
	public String form() {
		return "eventos/formEvento";
	}

	@PostMapping
	public String adicionar(Evento evento) {

		System.out.println(evento);
		er.save(evento);

		return "eventos/evento-adicionado";
	}

	@GetMapping
	public ModelAndView listar() {
		List<Evento> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("eventos/lista");
		mv.addObject("eventos", eventos);
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhar (@PathVariable Long id) {
 		ModelAndView md = new ModelAndView;
		Optional<Evento> opt = er.findById(id);
		
		if (opt.isEmpty()) {
			md.setViewName("redirect:/eventos);
			return md;
		}
		
		md.setViewName("eventos/detalhes");
		Evento evento = opt.get();
		md.addObject("evento", evento);
		
		List<Convidado> convidados = cr.findByEvento(evento);
		md.addObject("convidados", convidados);
		
		return m;
	
 	}

	@PostMapping("/{idEvento}")
 	public String salvarConvidado(@PathVariable Long idEvento, Convidado convidado) {
 		
 		System.out.println("Id do evento: " + idEvento");
 		System.out.println(convidado);
 		
 		Optional<Evento> opt = er.findById(idEvento);
 		if(opt.isEmpty()) {
 			return "redirect:/eventos";
 		
 		}
 		
 		Evento evento = opt.get();
 		convidado.setEvento(evento);
 		
 		cr.save(convidado);
 		
 		return "redirect:/eventos/{idEvento}";
 		
 	}
}
