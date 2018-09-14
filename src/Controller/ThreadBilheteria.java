package Controller;

import java.util.concurrent.Semaphore;

public class ThreadBilheteria	extends Thread {

	public Semaphore semaforo;
	
	public void ThreadBilhete() {
		
	}
	
	@Override
	public void run() {
		start();
	}
	
	public boolean processar(int idThread){
		 
		System.out.println("Usuário #" +idThread +" Logando...");
		double sleepTime = (double) Math.random()*2;
		
		if (sleepTime <= 1) {
			return true;
		}
		
		System.err.println("Login TimedOut");
		return false;
		
		
	}
	
}
