package com.example.simplifica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.simplifica.model.ResultadoTesouro;
import com.example.simplifica.repository.ResultadoTesouroRepository;
import com.example.simplifica.service.QuizService;

@Controller
public class ResultadoController {

    @Autowired
    QuizService qService;
    @Autowired
    ResultadoTesouro rt;
    @Autowired
    ResultadoTesouroRepository resultadoTP;

    @GetMapping("/resultado-usuario")
	public String score(Model model, @RequestParam Long id) {        
        model.addAttribute("resultadoUsuario", resultadoTP.findById(id));
		return "resultado_usuario";
	}


    @GetMapping("/ranking")
	public String score(Model model) {
        model.addAttribute("ranking", resultadoTP.findAll());
		return "ranking";
	}
}
