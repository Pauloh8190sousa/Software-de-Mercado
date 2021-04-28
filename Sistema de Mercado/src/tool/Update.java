package tool;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class Update {
	
	public synchronized static float gravaArquivoDeURL(String archive, String local, String nomeDoArquivo, String extesao, ProgressBar progress, ProgressIndicator indicador) {
		double bytesFile;
		try {
			URL url = new URL(archive);

			URLConnection con = url.openConnection();

			BufferedInputStream buf = new BufferedInputStream(con.getInputStream());

			FileOutputStream fos = new FileOutputStream(local + "/" + nomeDoArquivo + extesao);
			
			bytesFile = ((con.getContentLengthLong() / 1024) / 1024);
			int totalBytesCopied = 0;
			int i = 0;
			byte[] bytesIn = new byte[1024];
			indicador.setVisible(false);
			progress.setVisible(true);
			while ((i = buf.read(bytesIn)) >= 0) {
				fos.write(bytesIn, 0, i);
				totalBytesCopied += i;
				System.out.println("totalCopiado: " + totalBytesCopied);
				if (bytesFile != -1) {
					double megabytes = ((totalBytesCopied / 1024) / 1024);
					float percentual = (float) ((megabytes * 100) / bytesFile);
					progress.setProgress(percentual/100);
				} else {
					System.out.println("???");
					System.out.println("???%");
				}
			}
			fos.close();
			buf.close();
		} catch (Exception ex) {
			return 0;
		}
		return (float) bytesFile;
	}

}
