package com.example.simplifica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.simplifica.model.Tesouro;
import com.example.simplifica.model.TesouroForm;
import com.example.simplifica.repository.ResultadoTesouroRepository;
import com.example.simplifica.repository.TesouroRepository;


@Service
public class QuizService {	
	
	@Autowired
	Tesouro tesouro;
	@Autowired
    TesouroForm tForm;
	@Autowired
    TesouroRepository tr;
	@Autowired
	ResultadoTesouroRepository resultadoTP;
	
	public TesouroForm getPerguntas() {
		List<Tesouro> aux = tr.findAll();		
		
		tForm.setPerguntas(aux);
		
		return tForm;
	}	

	public int resultado(TesouroForm tForm) {
		int corretas = 0;
		for (Tesouro t : tForm.getPerguntas()) {
            if (t.getResposta() == t.getEscolha()){
				corretas++;
			}
        } 		
		return corretas;
	}
	
	
}
