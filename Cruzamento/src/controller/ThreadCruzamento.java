package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread{

	private int idCarro;
	private Semaphore semaforo;
	static private int ordemDeSaida;
	private int sentidoRandom;
	private static String sentido;
	

	public ThreadCruzamento(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		Ordem();
		try {
			semaforo.acquire();
			Saindo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Saida();
			semaforo.release();
		}
	}
	
	private void Ordem() {
		Random random = new Random();
		int sorte = random.nextInt(120);
		try {
			sleep(sorte);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void Saindo() {
		Random random = new Random();
		sentidoRandom = random.nextInt(4);
		switch(sentidoRandom){
			case 1:
			sentido = "norte";
			break;
			case 2:
			sentido = "sul";
			break;
			case 3:
			sentido = "leste";
			break;
			default:
			sentido = "oeste";
			break;
		}
		try {
			sleep(vm);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Saida() {
		ordemDeSaida++;
		System.out.println(idCarro + " saiu " + ordemDeSaida + "�");
	}
}
