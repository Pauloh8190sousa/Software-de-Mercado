package system;

import dataBase.AdminDataBase;

public class GerenciadorAdmin {
	private static Admin admin = AdminDataBase.load("C:/Mercado Tech/user/admin/admin");
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
	public String getNomeAdmin(){
		return admin.getNome();
	}
	public String getEmailAdmin(){
		return admin.getEmail();
	}
	public void addSenhaAdmin(String password){
		admin.setSenha(password);
		AdminDataBase.save("C:/Mercado Tech/user/admin/admin", admin);
	}
	public void addEmailAdmin(String email){
		admin.setEmail(email);
		AdminDataBase.save("C:/Mercado Tech/user/admin/admin", admin);
	}
	public void addNomeAdmin(String nome){
		admin.setNome(nome);
		AdminDataBase.save("C:/Mercado Tech/user/admin/admin", admin);
	}
}
