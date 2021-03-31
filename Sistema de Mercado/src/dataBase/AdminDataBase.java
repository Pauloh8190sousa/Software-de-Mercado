package dataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import system.Estoque;

public class AdminDataBase {

	private static XStream xstream = new XStream((HierarchicalStreamDriver)new DomDriver("ISO-8859-1"));
	   
	   private static File arquivo;
	   
	   public static void save(String estoqueArquivo, Estoque gerenciador) {
	     File arquivo = new File("C:/Mercado Tech");
	     if (!arquivo.exists())
	       arquivo.mkdirs(); 
	     arquivo = new File(String.valueOf(estoqueArquivo) + ".xml");
	     String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
	     xml = String.valueOf(xml) + xstream.toXML(gerenciador);
	     try {
	       arquivo.createNewFile();
	       PrintWriter gravar = new PrintWriter(arquivo);
	       gravar.print(xml);
	       gravar.close();
	     } catch (IOException e) {
	       e.printStackTrace();
	     } 
	   }
	   
	   public static Estoque load(String estoqueArquivo) {
	     arquivo = new File(String.valueOf(estoqueArquivo) + ".xml");
	     try {
	       if (arquivo.exists()) {
	         FileInputStream fis = new FileInputStream(arquivo);
	         return (Estoque)xstream.fromXML(fis);
	       } 
	     } catch (FileNotFoundException e) {
	       e.printStackTrace();
	     } 
	     return new Estoque();
	   }
}
