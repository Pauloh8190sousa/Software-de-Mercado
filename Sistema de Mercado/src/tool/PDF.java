package tool;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.filechooser.FileSystemView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import system.NotaFiscal;

public class PDF {
	  
	  public void gerarDadosDoCliente(NotaFiscal notaFiscal, String arquivo) {
		     Rectangle p = new Rectangle(PageSize.A5);
		     p.setBackgroundColor(new BaseColor(0, 225, 121));
		     Document document = new Document(p);
		     try {
		       FileSystemView system = FileSystemView.getFileSystemView();
		       String path = system.getHomeDirectory().getPath() + "/" + arquivo;
		       PdfWriter.getInstance(document, new FileOutputStream(path));
		       document.open();
		       Paragraph paragrafo1 = new Paragraph("NOTA FISCAL");
		       paragrafo1.setAlignment(1);
		       document.add(paragrafo1);
		       document.add(new Paragraph("-------------------------------------------------------------------------------------"));
		         document.add((Element)new Paragraph("°) \nNOME:  "));
		         document.add((Element)new Paragraph("-------------------------------------------------------------------------------------"));
		       Date data = new Date();
		       SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
		       String dataFormate = simple.format(data);
		       Paragraph paragrafo2 = new Paragraph("DOCUMENTO IMPRESSO NO DIA: " + dataFormate + "h");
		       paragrafo2.setAlignment(1);
		       document.add((Element)paragrafo2);
		     } catch (FileNotFoundException e) {
		       e.printStackTrace();
		     } catch (DocumentException e) {
		       e.printStackTrace();
		     } 
		     document.close();
		   }
}
