package View;

import Controller.ThreadBilheteria;

public class Principal {

	public static void main(String[] args) {

//		Thread tBilheteria = new ThreadBilheteria();	

		for (int i = 1; i <= 300; i++) {
			Thread tBilheteria = new ThreadBilheteria(i);	
			tBilheteria.start();
		}
	}

}
