package system;

import java.time.LocalDate;
import java.util.ArrayList;

import dataBase.EstoqueDataBase;

public class Caixa {
	private static Estoque estoque = EstoqueDataBase.load("C:/Mercado Tech/data/estoques/estoque_product");
	private static NotaFiscal nota = new NotaFiscal(new ArrayList<>());
	private static Caixa caixa;
	
	private Caixa() {
	}
	
	public synchronized static Caixa getInstance(){
		if(caixa==null){
			caixa = new Caixa();
		}
		return caixa;
	}

	public static Product lerCodBarra(double cod){
		return estoque.pesquisar(cod);
	}
	public void addProductNotaFiscal(double cod){
		nota.addProduct(lerCodBarra(cod));
		removeProductEstoque(cod);
	}
	public void addProductEstoque(float valor, double cod, String des, float grama, LocalDate validade, LocalDate fabricacao){
		estoque.addProduct(valor, cod, des, grama, validade, fabricacao);
		EstoqueDataBase.save("C:/Mercado Tech/data/estoques/estoque_product", estoque);
	}
	private boolean removeProductEstoque(double cod){
		boolean retorno = estoque.remove(cod);
		EstoqueDataBase.save("C:/Mercado Tech/data/estoques/estoque_product", estoque);
		return retorno;
	}
	public NotaFiscal getNotaFiscal(){
		return nota;
	}
	public static void limparNota(){
		nota = new NotaFiscal(new ArrayList<>());
	}
}
