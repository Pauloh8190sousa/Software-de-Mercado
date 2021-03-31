package system;

import java.util.ArrayList;

import dataBase.EstoqueDataBase;

public class Caixa {
	private Estoque estoque = EstoqueDataBase.load("C:/Mercado Tech/estoque.xml");
	private NotaFiscal nota = new NotaFiscal(new ArrayList<>());
	
	public Product lerCodBarra(double cod){
		return estoque.pesquisar(cod);
	}
	public void addProductNotaFiscal(double cod){
		nota.addProduct(lerCodBarra(cod));
		removeProductEstoque(cod);
	}
	public void addProductEstoque(float valor, double cod, String des, float grama){
		estoque.addProduct(valor, cod, des, grama);
		EstoqueDataBase.save("C:/Mercado Tech/estoque.xml", estoque);
	}
	private boolean removeProductEstoque(double cod){
		boolean retorno = estoque.remove(cod);
		EstoqueDataBase.save("C:/Mercado Tech/estoque.xml", estoque);
		return retorno;
	}
	public NotaFiscal getNotaFiscal(){
		return nota;
	}
	public void limparNota(){
		nota = new NotaFiscal(new ArrayList<>());
	}
}
