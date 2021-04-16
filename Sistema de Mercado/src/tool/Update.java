package tool;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Update {
	
	public static File atualizar(String stringUrl, String pathLocal){
		try {
//			Desktop desk = Desktop.getDesktop();
//			desk.browse(new URI(stringUrl));
			
			URL url = new URL(stringUrl);
			
			String nomeArquivoLocal = "version";

            URLConnection con = url.openConnection();
            
            BufferedInputStream buf = new BufferedInputStream(con.getInputStream());
            
            FileOutputStream fos = new FileOutputStream(pathLocal+nomeArquivoLocal+".json");

	            int i = 0;
	            byte[] bytesIn = new byte[100*1000*1024];
	            while ((i = buf.read(bytesIn)) >= 0) {
	                fos.write(bytesIn, 0, i);
	            }

			fos.close();
			buf.close();

			return new File(pathLocal+nomeArquivoLocal+".json");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
