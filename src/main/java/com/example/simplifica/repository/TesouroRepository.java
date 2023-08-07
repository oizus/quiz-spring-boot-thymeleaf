package com.example.simplifica.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.simplifica.model.Tesouro;

@Repository
public class TesouroRepository {
    @Autowired
    JdbcTemplate jdbc;

    public List<Tesouro> findAll() {
        return jdbc.query("select id_tesouro, titulo, opcaoA, opcaoB, opcaoC, resposta, escolha, id_usuario from tesouro;",
                (resultSet, rowNum) -> {
                    Tesouro tesouro = new Tesouro();
                    tesouro.setId(resultSet.getLong("id_tesouro"));
                    tesouro.setTitulo(resultSet.getString("titulo"));
                    tesouro.setOpcaoA(resultSet.getString("opcaoA"));
                    tesouro.setOpcaoB(resultSet.getString("opcaoB"));
                    tesouro.setOpcaoC(resultSet.getString("opcaoC"));
                    tesouro.setResposta(resultSet.getInt("resposta"));
                    tesouro.setEscolha(resultSet.getInt("escolha"));
                    tesouro.setIdUsuario(resultSet.getInt("id_usuario"));
                    return tesouro;
                });

    }
}
