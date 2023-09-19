package br.gov.sp.etec.gestaofesta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.etec.gestaofesta.model.Convidado;
import br.gov.sp.etec.gestaofesta.model.Login;
import br.gov.sp.etec.gestaofesta.repository.ConvidadoRepository;
import br.gov.sp.etec.gestaofesta.repository.LoginRepository;

@Controller
public class LoginController {

	@Autowired
	ConvidadoRepository repo;

	@Autowired
	LoginRepository loginRepository;

	@GetMapping("/")
	public String abrirLogin() {
		return "login";
	}

	@PostMapping("/logar")
	public ModelAndView logarSistema(Login loginEntrada) {

		Login loginRetorno = loginRepository.findByEmail(loginEntrada.getEmail());

		if (loginEntrada.getEmail().equals(loginRetorno.getEmail())
				&& loginEntrada.getSenha().equals(loginRetorno.getSenha())) {
			List<Convidado> listaConvidados = repo.findAll();
			ModelAndView view = new ModelAndView("lista-convidado");
			view.addObject("convidados", listaConvidados);
			return view;

		} else {
			ModelAndView view = new ModelAndView("login");
			return view;
		}
	}

	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "cadastro-login";
	}

	@PostMapping("/efetivar")
	public String efetivar(Login login) {
		// Chamar banco para salvar os dados
		loginRepository.save(login);
		return "login";

	}
}
