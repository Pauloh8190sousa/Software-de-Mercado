package system;

import java.util.ArrayList;

public class NotaFiscal {
	private ArrayList<Product> product;
	
	public NotaFiscal(ArrayList<Product> product) {
		this.product = product;
	}
	public float getPreco(){
		float preco = 0;
		for(Product p: product){
			preco+=p.getPreco();
		}
		return preco;
	}
	public String getCodBarra(){
		String cod = "";
		for(Product p: product){
			cod+=p.getCodBarra()+"\n";
		}
		return cod;
	}
	public String getGrama(){
		String gramas = "";
		for(Product p: product){
			gramas+=p.getGrama()+"g\n";
		}
		return gramas;
	}
}
