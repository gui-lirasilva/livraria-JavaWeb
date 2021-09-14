package br.com.livraria.modelo;

import java.time.LocalDate;

public class Autor {
	
	private Integer id;
	private String nome;
	private LocalDate dataNascimento;
	private String email;
	private String miniCurriculo;
	
	public Autor() {
		
	}
	
	public Autor(String nome, LocalDate dataNascimento, String email, String miniCurriculo) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.miniCurriculo = miniCurriculo;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMiniCurriculo() {
		return miniCurriculo;
	}
	public void setMiniCurriculo(String miniCurriculo) {
		this.miniCurriculo = miniCurriculo;
	}
	
	
	@Override
	public String toString() {
		return "Autor: " + nome + "\n" +
				"Email: " + email + "\n" +
				"Id: " + id + "\n" +
				"Mini Curriculo: " + miniCurriculo + "\n" +
				"-------------";
	}
	
}
