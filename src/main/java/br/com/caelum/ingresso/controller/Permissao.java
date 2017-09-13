package br.com.caelum.ingresso.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permissao {
	
	@Id
	private String nome;
	
	public Permissao(String nome){
		this.nome = nome;
	}
	public Permissao(){
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
