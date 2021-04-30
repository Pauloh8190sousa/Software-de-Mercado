package system;

import java.time.LocalDate;

public class Product {
	private float preco;
	private double codBarra;
	private String descricao;
	private float grama;
	private LocalDate dataValidade;
	private LocalDate dataFabricacao;
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public double getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(double codBarra) {
		this.codBarra = codBarra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getGrama() {
		return grama;
	}
	public void setGrama(float grama) {
		this.grama = grama;
	}
	public LocalDate getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
}
