package br.com.caelum.ingresso.model;


public class Carrinho {
	

	public Compra toCompra(){
		return new Compra(ingressos);
	}

}
