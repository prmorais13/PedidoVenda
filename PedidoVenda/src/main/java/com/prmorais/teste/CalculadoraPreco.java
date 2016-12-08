package com.prmorais.teste;

import java.io.Serializable;

public class CalculadoraPreco implements Serializable {

	private static final long serialVersionUID = 1L;

	public double calcularPreco(int quantidade, double precoUnitario){
		return quantidade * precoUnitario;
	}

}
