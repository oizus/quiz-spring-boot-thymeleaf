package com.example.simplifica.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.simplifica.model.UsuarioSimples;

@Repository
public class UsuarioSimplesRepository {
	@Autowired
	JdbcTemplate jdbc;

	private static Connection connection;

	public Long save(UsuarioSimples usuarioSimples) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/x";
		String username = "root";
		String password = "casa";
		Long idUsuario = null;

		connection = DriverManager.getConnection(url, username, password);

		String QUERY = "insert into usuario_simples(nome) values (?);";

		try (PreparedStatement statement = connection.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, usuarioSimples.getNome());

			int affectedRows = statement.executeUpdate();

			try (ResultSet keys = statement.getGeneratedKeys()) {
				keys.next();
				idUsuario = keys.getLong(1);
			}

		}
		return idUsuario;

	}

	public UsuarioSimples findById(Long id) {
		return jdbc.queryForObject("select * from usuario_simples where id_usuario_simples=?", this::mapper, id);
	}

	private UsuarioSimples mapper(ResultSet registro, int contador) throws SQLException {
		return new UsuarioSimples(registro.getLong("id_usuario_simples"), registro.getString("nome"));
	}

}
