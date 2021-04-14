package tool;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.auth.DbxAppAuthRequests;
import com.dropbox.core.v2.files.DbxAppFilesRequests;
import com.dropbox.core.v2.users.FullAccount;


public class Update {

	/** Arquivo para update */
//	private String urlUpdateFile = "http://ENDEREÇO_DO_SEU_JAR/arquivo.jar";

	/** Faz download de arquivo */
	public void atualizar(String address, String localFileName, String host, int porta) {

//		// leitor do arquivo a ser baixado
//		InputStream in = null;
//		// conexão com a internete
//		URLConnection conn = null;
//		// escritor do arquivo que será baixado
//		OutputStream out = null;
//
//		System.out.println("Update.download() BAIXANDO Atualização " + address);
//
//		try {
//			URL url = new URL(address);
//			out = new BufferedOutputStream(new FileOutputStream(localFileName));
//
//			// verifica se existe proxy
//			if (host != "" && host != null) {
//				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, porta));
//				conn = url.openConnection(proxy);
//			} else {
//				conn = url.openConnection();
//			}
//
//			in = conn.getInputStream();
//			byte[] buffer = new byte[1024];
//			int numRead;
//			long numWritten = 0;
//			while ((numRead = in.read(buffer)) != -1) {
//				out.write(buffer, 0, numRead);
//				numWritten += numRead;
//			}
//			System.out.println(localFileName + "\t" + numWritten);
//
//		} catch (Exception exception) {
//			exception.printStackTrace();
//		} finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//				if (out != null) {
//					out.close();
//				}
//			} catch (IOException ioe) {
//			}
//		}
	}
	public void dowload(String filename){
//		String url="https://www.dropbox.com/preview/Mercado%20Tech/iPhone%20X%20Note%20(Notifica%C3%A7%C3%A3o).mp3"; 
//		try{ 
//		URL download=new URL(url); 
//		ReadableByteChannel rbc=Channels.newChannel(download.openStream()); 
//		FileOutputStream fileOut = new FileOutputStream(filename); 
//		fileOut.getChannel().transferFrom(rbc, 0, 1 << 24); 
//		fileOut.flush(); 
//		fileOut.close(); 
//		rbc.close();
//	        
//		System.out.println("Baixou");
//		}catch(Exception e){ 
//			e.printStackTrace();
//			} 
	}
}
