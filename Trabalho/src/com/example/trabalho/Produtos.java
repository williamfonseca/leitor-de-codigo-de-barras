package com.example.trabalho;

public class Produtos {

	String nome, precoProduto;
	double preco;
	int imagemId;
	String cod_barra; 
	
	public Produtos(){
		
	}
	
	public Produtos(String n, double p, int id, String c){
		this.nome = n;
		this.preco = p;
		this.imagemId = id;
		this.cod_barra = c;
		
	}
	
	public String getNome(){
		return nome;
	}
	
	public double getPreco(){
		return preco;
	}
	
	public int getImagemId(){
		return imagemId;
	}
	
	public String getCod_Barra(){
		return cod_barra;
	}
	
	public String toString(){
		return this.precoProduto;
	}
}
