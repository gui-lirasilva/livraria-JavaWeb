package br.com.livraria.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.livraria.dao.AutorDao;
import br.com.livraria.modelo.Autor;

public class TestaSelect {
	
public static void main(String[] args) {
		
		try {
			String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC";
			String usuario = "root";
			String senha = "133708";
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			AutorDao autorDao = new AutorDao(conexao);
			
			List<Autor> autores =  autorDao.listar();
			
			autores.forEach(System.out::println); 
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro");
		}
		
		
		
	}
}
