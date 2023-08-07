package com.example.simplifica.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Tesouro {
    private long id;
    private String titulo;
    private String opcaoA;
    private String opcaoB;
    private String opcaoC;
    private int resposta;
    private int escolha;
    private int idUsuario;

    @Override
	public String toString() {
		return "Pergunta [id =" + id + ", titulo = " + titulo + ", opcaoA = " + opcaoA + ", opcaoB = " + opcaoB + ", opcaoC = " + opcaoC + ", resposta = " + resposta + ", escolha = " + escolha +  ", id_usuario = " + idUsuario + "]";
	}

}
