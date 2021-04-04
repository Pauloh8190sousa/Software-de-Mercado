package dataBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeitorJSON {

	public void lerJSON() {
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();

		String nome;
		String desenvolvedor;
		String data;
		String hora;
		String versao;

		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"version.json"));

			nome = (String) jsonObject.get("nome");
			desenvolvedor = (String) jsonObject.get("Desenvolvedor");
			data = (String) jsonObject.get("data");
			hora = (String) jsonObject.get("hora");
			versao = (String) jsonObject.get("versão");
			System.out.printf(
					"Nome: %s\nDesenvolvedor: %s\nData: %s\nHora: %s\nVersão: %s\n",
					nome, desenvolvedor, data, hora, versao);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public Object atualizarJSON(Object chave, Object valor){
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		FileWriter fileWriter = null;
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"version.json"));
			Object obj = jsonObject.replace(chave, valor);
			fileWriter = new FileWriter("version.json");
			fileWriter.write(jsonObject.toJSONString());
			fileWriter.close();
			return obj;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
