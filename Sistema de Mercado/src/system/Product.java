package system;


public class Product {
	private float preco;
	private double codBarra;
	private String descricao;
	private float grama;
	private String dataValidade;
	private String dataFabricacao;
	
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
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
}
