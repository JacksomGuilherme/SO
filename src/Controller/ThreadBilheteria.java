package Controller;

import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	public static Semaphore semaforo;
	static int totalIngressos = 100;

	public void ThreadBilhete() {

	}

	public static void login(int idThread) {

		try {
			System.out.println("Usuário #" + idThread + " Logando...");
			double sleepTime = (double) (Math.random() * 2.1);

			if (sleepTime <= 1) {
				processoCompra(idThread);
			} else {
				Thread.interrupted();
				System.err.println("Usuário #" + idThread + " Login TimedOut");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void processoCompra(int idThread) {

		double sleepTime = (double) (1 + Math.random() * 3.1);

		int ingresso = (int) (1 + Math.random() * 4);

		if (sleepTime <= 2.5) {
			validacao(idThread, ingresso);
		} else {
			Thread.interrupted();
			System.err.println("Usuário #" + idThread + " TimedOut");
		}

	}

	public static void validacao(int idThread, int ingresso) {

		try {
			semaforo.acquire();
			if ((totalIngressos <= 0) || (totalIngressos - ingresso < 0)) {
				System.err.println("Ingressos Esgotados");
				Thread.interrupted();
			} else {
				totalIngressos -= ingresso;
				System.out.println("Usuário #" + idThread + " Compra Efetuada");
				System.out.println("Qtd Comparada: " + ingresso
						+ "\n Ingressos Restantes: " + totalIngressos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	static Thread go = new Thread() {

		public void run() {
			for (int i = 1; i <= 300; i++) {
				login(i);
			}
		}
	};

	public static void main(String[] args) {

		int permicoes = 1;
		semaforo = new Semaphore(permicoes);
		go.start();

	}
}
