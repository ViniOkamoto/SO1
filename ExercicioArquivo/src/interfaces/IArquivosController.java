package interfaces;

import java.io.IOException;

public interface IArquivosController {
	
	public void convertFile(String path, String name) throws IOException;
	public void openFile(String path, String name) throws IOException;

}
