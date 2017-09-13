package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoDeTrintaPorCentoParaBancos implements Desconto{

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.subtract(trintaPorCentoSobre(precoOriginal));
	}
	
	private BigDecimal trintaPorCentoSobre(BigDecimal precoOriginal){
		BigDecimal percentualDeDesconto = new BigDecimal("0.3");
		return precoOriginal.multiply(percentualDeDesconto);
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "Desconto Banco";
	}

}
