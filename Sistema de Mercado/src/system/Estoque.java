package system;
import java.util.ArrayList;

public class Estoque {
	private ArrayList<Product> produtos = new ArrayList<>();
	
	public void addProduct(float valor, double cod, String des, float grama,String validade, String fabricacao){
		Product prod = new Product();
		prod.setPreco(valor);
		prod.setCodBarra(cod);
		prod.setDescricao(des);
		prod.setGrama(grama);
		prod.setDataValidade(validade);
		prod.setDataFabricacao(fabricacao);
		produtos.add(prod);
	}
	public boolean remove(double cod){
		for(Product prod: produtos){
			if(prod.getCodBarra()==cod){
				produtos.remove(prod);
				return true;
			}
		}
		return false;
	}
	public Product pesquisar(double cod){
		for(Product p: produtos){
			if(p.getCodBarra()==cod){
				return p;
			}
		}
		return null;
	}
	public ArrayList<Product> getProdutos(){
		return produtos;
	}
}
