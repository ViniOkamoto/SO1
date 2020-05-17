package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCorridor extends Thread {

	private Semaphore door;
	private int person;
	private int timeInCorridor;
	private int timeOpenDoor;
	private static int posicaoSaida;
	public ThreadCorridor(int person, Semaphore door) {
		this.door = door;
		this.person = person;
	}
	@Override
	public void run() {
		walkOpenDoor();
		try {
			door.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			door.release();
			posicaoSaida++;
			System.out.println("O corredor " + person + " chegou em " + posicaoSaida + "° em "+ timeInCorridor + " segundos e abriu a porta em " + timeOpenDoor + " segundos" );
		}
		super.run();
	}
	

	private void walkOpenDoor() {
		Random rd = new Random();
		int dist = 0;
		int speed = rd.nextInt((6-4)+1)+ 4;
		System.out.println("O corredor " + person + " está andando à " + speed + "m/s" );
		while(dist < 200) {
			dist += speed;
			timeInCorridor+=1;
		}
		timeOpenDoor = rd.nextInt((2-1)+1) + 1;
		try {
			sleep(timeOpenDoor*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
