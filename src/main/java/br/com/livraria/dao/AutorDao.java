package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.livraria.modelo.Autor;

public class AutorDao {

	private Connection conexao;
	
	public AutorDao(Connection conexao) {
        this.conexao = conexao;
    }

	public void cadastrar(Autor autor) {

		try {
			String sql = "insert into autores(nome, dataNascimento, email, miniCurriculo) values(?, ?, ?, ?)";
			PreparedStatement ps = this.conexao.prepareStatement(sql);

			ps.setString(1, autor.getNome());
			ps.setDate(2, Date.valueOf(autor.getDataNascimento()));
			ps.setString(3, autor.getEmail());
			ps.setString(4, autor.getMiniCurriculo());
			ps.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Autor> listar() {
		try {
			String sql = "select * from autores";
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList autores = new ArrayList();

			while (rs.next()) {
				Autor autor = new Autor();
				autor.setId(rs.getInt(1)); // Para pegar o que está armazenado na coluna 1 da tabela
				autor.setNome(rs.getString("nome"));
				autor.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
				autor.setEmail(rs.getString("email"));
				autor.setMiniCurriculo(rs.getString("miniCurriculo"));
				autores.add(autor);
			}

			return autores;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Autor autor, Integer id) {
		try {
			String sql = "UPDATE autores SET nome = ?, dataNascimento = ?, email = ?, miniCurriculo = ? WHERE id = ?";
			PreparedStatement ps = this.conexao.prepareStatement(sql);

			ps.setString(1, autor.getNome());
			ps.setDate(2, Date.valueOf(autor.getDataNascimento()));
			ps.setString(3, autor.getEmail());
			ps.setString(4, autor.getMiniCurriculo());
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(Integer id) {
		try {
			String sql = "delete from autores where id=?";
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException var4) {
			throw new RuntimeException(var4);
		}
	}

	public Autor buscaAutorPelaId(Integer id) {
		try {
			String sql = "select * from autores";
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList autores = new ArrayList();

			Autor autor;
			while (rs.next()) {
				autor = new Autor();
				autor.setId(rs.getInt(1));
				autor.setNome(rs.getString("nome"));
				autor.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
				autor.setEmail(rs.getString("email"));
				autor.setMiniCurriculo(rs.getString("miniCurriculo"));
				autores.add(autor);
			}

			Iterator iterator = autores.iterator();

			while (iterator.hasNext()) {
				autor = (Autor) iterator.next();
				if (autor.getId() == id) {
					return autor;
				}
			}

			return null;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
