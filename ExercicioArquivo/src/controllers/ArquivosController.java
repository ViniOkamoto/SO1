package controllers;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import interfaces.IArquivosController;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	@Override
	public void convertFile(String path, String name) throws IOException {
		File arq = new File(path, name + ".txt");
		if (arq.exists() && arq.isFile()) {
			FileInputStream flow = new FileInputStream(arq);
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			String textFormatted = line + "\n";
			while(line != null) {
				line = buffer.readLine();
				if(line!=null) {
					String [] texts = line.split(" ");
					for(String text : texts) {
						textFormatted += text + " ;";
					}
					textFormatted += " ";
					textFormatted += "\n";
				}
				System.out.println(textFormatted);
				
			}
			createFile(textFormatted, path, name);
			buffer.close();
			reader.close();
			flow.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

	private void createFile(String text, String path, String name) throws IOException {
		File dir = new File(path);
		File arq = new File(path, name + ".csv");
		if (dir.exists() && dir.isDirectory()) {
			FileWriter fileWriter = new FileWriter(arq);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.write(text);
			printWriter.flush();
			printWriter.close();
			fileWriter.close();
		} else {
			throw new IOException("Arquivo não encontrado");
		}
		
	}
	
	@Override
	public void openFile(String path, String name) throws IOException {
		File arq = new File(path, name + ".csv");
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}
	
}
