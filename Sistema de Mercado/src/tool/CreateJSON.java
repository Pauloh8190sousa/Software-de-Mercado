package tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CreateJSON {

	public void criarConfigJSON() {
		JSONObject json = null;
		FileWriter fileWriter;
		File arquivo = new File("C:/Mercado Tech/config");
		if (!arquivo.exists()) {
			arquivo.mkdirs();
		}
		try {
			json = new JSONObject();
			fileWriter = new FileWriter("C:/Mercado Tech/config/config.json");
			fileWriter.write(json.toJSONString());
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public boolean addChaveEValorConfig(String chave, Object valor){
		JSONObject json = null;
		FileWriter fileWriter;
		File arquivo = new File("C:/Mercado Tech/config");
		if (!arquivo.exists()) {
			return false;
		}
		JSONParser parser = new JSONParser();
		try {
			json = (JSONObject) parser.parse(new FileReader(
					"C:/Mercado Tech/config/config.json"));
			json.put(chave, valor);
			fileWriter = new FileWriter("C:/Mercado Tech/config/config.json");
			fileWriter.write(json.toJSONString());
			fileWriter.close();
		}
		catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ParseException e) {
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	public boolean atualizarValorConfig(String chave, Object valor){
		JSONObject json = null;
		FileWriter fileWriter;
		File arquivo = new File("C:/Mercado Tech/config");
		if (!arquivo.exists()) {
			return false;
		}
		JSONParser parser = new JSONParser();
		try {
			json = (JSONObject) parser.parse(new FileReader(
					"C:/Mercado Tech/config/config.json"));
			json.replace(chave, valor);
			fileWriter = new FileWriter("C:/Mercado Tech/config/config.json");
			fileWriter.write(json.toJSONString());
			fileWriter.close();
		}
		catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ParseException e) {
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	public void criarCredenciaisJSON(String email, String senha, String nome){
		JSONObject json = null;
		FileWriter fileWriter;
		File arquivo = new File("C:/Mercado Tech/user/credencials");
		if (!arquivo.exists()) {
			arquivo.mkdirs();
		}
		try {
			json = new JSONObject();
			json.put("E-mail", email);
			json.put("Senha", senha);
			json.put("Nome", nome);
			fileWriter = new FileWriter("C:/Mercado Tech/user/credencials/credencials.json");
			fileWriter.write(json.toJSONString());
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public JSONObject getConfigJSON(){
		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"C:/Mercado Tech/config/config.json"));
		}
		catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ParseException e) {
		}
		return jsonObject;
	}
	public JSONObject getCredenciaisJSON(){
		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"C:/Mercado Tech/user/credencials/credencials.json"));
		}
		catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ParseException e) {
		}
		return jsonObject;
	}
}
