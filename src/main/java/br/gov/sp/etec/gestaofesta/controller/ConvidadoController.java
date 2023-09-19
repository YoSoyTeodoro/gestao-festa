package br.gov.sp.etec.gestaofesta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.etec.gestaofesta.model.Convidado;
import br.gov.sp.etec.gestaofesta.repository.ConvidadoRepository;

	@Controller
	public class ConvidadoController {
	
	@Autowired
	ConvidadoRepository repo;
	
	@GetMapping("ola-mundo")
	public String olaMundo () {
		return "ola";
	}
	
	@GetMapping("formulario")
	public String CadastroConvidado () {
		return "CadastroConvidado";
	}
	@PostMapping("salvar-convidados")
	public ModelAndView salvarConvidados(Convidado con) {
		repo.save(con);
		List<Convidado> listaConvidados = repo.findAll();
		ModelAndView view = new ModelAndView("lista-convidado");
		view.addObject("convidados", listaConvidados);
		
	return view;
		
	}
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable Long id) {
		repo.deleteById(id);
		List<Convidado> listaConvidados = repo.findAll();
		ModelAndView view = new ModelAndView("lista-convidado");
		view.addObject("convidados", listaConvidados);
		return view;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Convidado c = repo.findById(id).get();
		ModelAndView view = new ModelAndView("editar-convidado");
		view.addObject("convidado", c);
		return view;
	}
}