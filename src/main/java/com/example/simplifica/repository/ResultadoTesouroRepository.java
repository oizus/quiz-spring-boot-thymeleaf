package com.example.simplifica.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.simplifica.model.ResultadoTesouro;

@Repository
public class ResultadoTesouroRepository {
    @Autowired
    JdbcTemplate jdbc;

    public void save(ResultadoTesouro rt) {
        String sql = "insert into resultado_tesouro(total_corretas, nome, id_usuario) values (?,?,?);";
        jdbc.update(sql, rt.getTotalCorretas(), rt.getNome(), rt.getId_usuario());
    }

    public List<ResultadoTesouro> findAll() {
        return jdbc.query("select nome, total_corretas From resultado_tesouro order by total_corretas desc;",
                (resultSet, rowNum) -> {
                    ResultadoTesouro rt = new ResultadoTesouro();
                    rt.setNome(resultSet.getString("nome"));
                    rt.setTotalCorretas(resultSet.getInt("total_corretas"));
                    return rt;
                });

    }

    public ResultadoTesouro findById(Long id) {
        return jdbc.queryForObject("select * from resultado_tesouro where id_usuario=?", this::mapper, id);
    }

    private ResultadoTesouro mapper(ResultSet registro, int contador) throws SQLException {
        return new ResultadoTesouro(registro.getInt("id_resultado_tesouro"), registro.getString("nome"),
                registro.getLong("id_usuario"), registro.getInt("total_corretas"));
    }

}
