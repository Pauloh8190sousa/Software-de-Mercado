package system;

import dataBase.AdminDataBase;

public class GerenciadorAdmin {
	private static Admin admin = AdminDataBase.load("C:/Mercado Tech/admin");
	private static GerenciadorAdmin gerenciador;
	
	private GerenciadorAdmin(){
	}
	
	public synchronized static GerenciadorAdmin getInstance(){
		if(gerenciador==null){
			gerenciador = new GerenciadorAdmin();
		}
		return gerenciador;
	}
	public static Admin getAdmin(){
		return admin;
	}
	public String getSenhaAdmin(){
		return admin.getSenha();
	}
	public String getEmailAdmin(){
		return admin.getEmail();
	}
	public static void addSenhaAdmin(String password){
		admin.setSenha(password);
	}
	public static void addEmailAdmin(String email){
		admin.setEmail(email);
	}
}
