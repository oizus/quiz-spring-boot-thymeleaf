package com.example.simplifica.controller;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.simplifica.model.ResultadoTesouro;
import com.example.simplifica.model.UsuarioSimples;
import com.example.simplifica.repository.UsuarioSimplesRepository;

@Controller
public class UsuarioSimplesController {
	@Autowired
	UsuarioSimplesRepository repository;
	@Autowired
    ResultadoTesouro rt;
	

	@GetMapping("/usuario")
	public String formCadastroUsuarioSimples(Model model) {
		model.addAttribute("usuariosimples", new UsuarioSimples());
		return "usuario";
	}

	@PostMapping("/usuario")
	public RedirectView gravaNovoUsuarioSimples(UsuarioSimples usuarioSimples, RedirectAttributes attributes, @RequestParam String nome)
			throws SQLException {
		Long id = repository.save(usuarioSimples);

		rt.setNome(nome);
		rt.setId_usuario(id);
		

		attributes.addAttribute("id", id);
		return new RedirectView("quiz");
	}

	
}
