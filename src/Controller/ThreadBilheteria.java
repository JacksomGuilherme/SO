package Controller;

import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	public static Semaphore semaforo;
	static int totalIngressos = 100;
	private int idThread;

	public ThreadBilheteria(int i) {
			this.idThread = i;
	}
	
	public void run() {
		int permicoes = 1;
		semaforo = new Semaphore(permicoes);
		login();
	}
	
	public void login() {

		try {
			System.out.println("Usuário #" + idThread + " Logando...");
			System.out.print("");
			double sleepTime = (double) (Math.random() * 2.1);

			if (sleepTime <= 1) {
				processoCompra();
			} else {
				Thread.interrupted();
				System.err.println("Usuário #" + idThread + " Login TimedOut");
				System.out.print("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void processoCompra() {

		double sleepTime = (double) (1 + Math.random() * 3.1);

		int ingresso = (int) (1 + Math.random() * 4);

		if (sleepTime <= 2.5) {
			validacao(ingresso);
		} else {
			Thread.interrupted();
			System.err.println("Usuário #" + idThread + " TimedOut");
			System.out.print("");
		}

	}

	public void validacao(int ingresso) {

		try {
			semaforo.acquire();
			if ((totalIngressos <= 0) || (totalIngressos - ingresso < 0)) {
				System.err.println("Ingressos Esgotados");
				Thread.interrupted();
			} else {
				totalIngressos -= ingresso;
				System.out.println("Usuário #" + idThread + " Compra Efetuada" +"\n"
						+"Qtd Comprada: " + ingresso
						+ "\nIngressos Restantes: " + totalIngressos);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}



}
