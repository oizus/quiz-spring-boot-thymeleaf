package com.example.simplifica.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoTesouro {
    private int id;	    
	private String nome;
	private Long id_usuario;
	private int totalCorretas = 0;  
    
    @Override
	public String toString() {
		return "Resultado [id =" + id + ", totalCorretas = " + totalCorretas + "]";
	}
}
