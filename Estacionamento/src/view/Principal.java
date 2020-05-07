package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Principal {

	public static void main(String args[]) {
		int permissoes = 3;
		Semaphore semaphore = new Semaphore(permissoes); 
		
		for (int i = 0; i < 10 ; i++) {
			Thread tCarro = new ThreadCarro(i, semaphore);
			tCarro.start();
		}
	}
}
