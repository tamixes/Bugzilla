package br.ufrpe.bugzilla.negocio.beans;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.ufrpe.bugzilla.gui.login.Login;

public class GeraPDF {
	
	public static void geradorPDF(Encomenda enc){
		
		Document documento = new Document();
		
		try{
			PdfWriter.getInstance(documento, new FileOutputStream("encomenda.pdf"));
			
			documento.open();
			Image img = Image.getInstance(Login.class.getResource("logo2_bugzilla.png"));
			documento.add(img);
			documento.add(new Paragraph ("\n\n\n"));
			documento.add(new Paragraph("Informações da Encomenda " + enc.getCodigo() + "\n\n\n\n"));
			documento.add(new Paragraph(enc.toString()+ "\n\n"));
			
		}catch(DocumentException e){
			System.out.println(e.getMessage());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			documento.close();
		}
		
		try{
			Desktop.getDesktop().open(new File("encomenda.pdf"));
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}

}
