package views;

import controllers.ArquivosController;
import interfaces.IArquivosController;

public class Principal {

	public static void main(String args[]) {
		IArquivosController arqCont = new ArquivosController();
		String path = "C:\\Users\\Vinicius Okamoto\\Documents";
		String name = "relatorio";
		
		try {
			
//			arqCont.readDir(dirWin);
			arqCont.convertFile(path, name);
			arqCont.openFile(path, name + ".csv");
		}catch(Exception err){
			err.printStackTrace();
		}
	}
	
}
