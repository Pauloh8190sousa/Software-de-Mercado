package tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class versionJSON {
	
	public boolean copia(JSONObject json){
		File arquivo = new File("C:/Mercado Tech/program_version");
	     if (!arquivo.exists()){
	    	 arquivo.mkdirs();
	     }
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter("C:/Mercado Tech/program_version/version.json");
				fileWriter.write(json.toJSONString());
				fileWriter.close();
				return true;
			} catch (IOException e) {
				return false;
			}
	}
	public JSONObject getCopia(){
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"C:/Mercado Tech/program_version/version.json"));
			return jsonObject;
		} catch (IOException | ParseException e) {
			return null;
		}
	}
	public boolean transferirCopiaParaPrograma(){
		JSONObject json = getCopia();
		if(json!=null){
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter("version/version.json");
				fileWriter.write(json.toJSONString());
				fileWriter.close();
				return true;
			} catch (IOException e) {
			}
		}
		return false;
	}
	@SuppressWarnings("unused")
	public boolean transferirServerParaPrograma(File file){
			JSONParser parser = new JSONParser();
			JSONObject json = null;
			try {
				json = (JSONObject) parser.parse(new FileReader(file));
				return true;
			} catch (IOException | ParseException e) {
			}
		return false;
	}
	@SuppressWarnings("unchecked")
	public void criarJSON(String nome, String dev, String versao){
	     	JSONObject jsonObject = null;
			FileWriter fileWriter = null;
			try {
				LocalDateTime local = LocalDateTime.now();
				jsonObject = new JSONObject();
				jsonObject.put("Nome", nome);
				jsonObject.put("Desenvolvedor", dev);
				jsonObject.put("Data", local.getDayOfMonth()+"/"+local.getMonthValue()+"/"+local.getYear());
				jsonObject.put("Hora", local.getHour()+":"+local.getMinute()+":"+local.getSecond()+"h");
				jsonObject.put("Versão", versao);
				fileWriter = new FileWriter("version/version.json");
				fileWriter.write(jsonObject.toJSONString());
				fileWriter.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public JSONObject lerJSON() {
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();

		String nome;
		String desenvolvedor;
		String data;
		String hora;
		String versao;

		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"version/version.json"));

			nome = (String) jsonObject.get("Nome");
			desenvolvedor = (String) jsonObject.get("Desenvolvedor");
			data = (String) jsonObject.get("Data");
			hora = (String) jsonObject.get("Hora");
			versao = (String) jsonObject.get("Versão");
			System.out.printf(
					"Nome: %s\nDesenvolvedor: %s\nData: %s\nHora: %s\nVersão: %s\n",
					nome, desenvolvedor, data, hora, versao);
			return jsonObject;
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
	@SuppressWarnings("unchecked")
	public Object atualizarJSON(Object chave, Object valor){
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		FileWriter fileWriter = null;
		try {
			LocalDateTime local = LocalDateTime.now();
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"version/version.json"));
			Object obj = jsonObject.replace(chave, valor);
			jsonObject.replace("Data", local.getDayOfMonth()+"/"+local.getMonthValue()+"/"+local.getYear());
			jsonObject.replace("Hora",local.getHour()+":"+local.getMinute()+":"+local.getSecond()+"h");
			fileWriter = new FileWriter("version/version.json");
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
