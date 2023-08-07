package com.example.simplifica.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSimples {
    private Long id;
    private String nome;    

    @Override
	public String toString() {
		return "Pergunta [id =" + id + ", nome = " + nome + "]";
	}
}
