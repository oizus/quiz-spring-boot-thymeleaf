package com.example.simplifica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.simplifica.model.ResultadoTesouro;
import com.example.simplifica.model.TesouroForm;
import com.example.simplifica.repository.RespostaTesouroRepository;
import com.example.simplifica.repository.ResultadoTesouroRepository;
import com.example.simplifica.service.QuizService;

@Controller
public class TesouroController {
    @Autowired
    TesouroForm tForm;
    @Autowired
    QuizService qService;
    @Autowired
    RespostaTesouroRepository rtp;
    @Autowired
    ResultadoTesouro rt;
    @Autowired
    ResultadoTesouroRepository resultadoTP;

    @GetMapping("/quiz")
    public String formQuiz(Model model) {
        TesouroForm tForm = qService.getPerguntas();
        model.addAttribute("tForm", tForm);
        return "quiz";
    }

    @PostMapping("/resultado")
    public RedirectView submit(TesouroForm tForm, Model model, RedirectAttributes attributes) {
        rtp.save(tForm);
        rt.setTotalCorretas(qService.resultado(tForm));
        resultadoTP.save(rt);

        attributes.addAttribute("id", rt.getId_usuario());
        
        return new RedirectView("resultado-usuario");

    }

}
