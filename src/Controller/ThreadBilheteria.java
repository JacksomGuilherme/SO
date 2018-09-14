package Controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	public Semaphore semaforo;

	public void ThreadBilhete() {

	}

	@Override
	public void run() {
		start();
	}

	public boolean processar(int idThread) {

		System.out.println("Usuário #" + idThread + " Logando...");
		double sleepTime = (double) (Math.random() * 2.1);

		if (sleepTime <= 1) {
			compra(idThread);
			return true;
		}

		Thread.interrupted();
		System.err.println("Usuário #" + idThread + " Login TimedOut");
		return false;

	}
	
	public boolean compra(int idThread){
		
		Random sleepTime = new Random();
		
		
		
		return false;
		
	}

	
}
