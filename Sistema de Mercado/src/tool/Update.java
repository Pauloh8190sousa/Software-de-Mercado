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

public class Update {

	/** Arquivo para update */
	private String urlUpdateFile = "http://ENDEREÇO_DO_SEU_JAR/arquivo.jar";

	/** Faz download de arquivo */
	public void download(String address, String localFileName, String host, int porta) {

		// leitor do arquivo a ser baixado
		InputStream in = null;
		// conexão com a internete
		URLConnection conn = null;
		// escritor do arquivo que será baixado
		OutputStream out = null;

		System.out.println("Update.download() BAIXANDO Atualização " + address);

		try {
			URL url = new URL(address);
			out = new BufferedOutputStream(new FileOutputStream(localFileName));

			// verifica se existe proxy
			if (host != "" && host != null) {
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, porta));
				conn = url.openConnection(proxy);
			} else {
				conn = url.openConnection();
			}

			in = conn.getInputStream();
			byte[] buffer = new byte[1024];
			int numRead;
			long numWritten = 0;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}
			System.out.println(localFileName + "\t" + numWritten);

		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
			}
		}
	}

}
