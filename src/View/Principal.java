package View;

import Controller.ThreadBilheteria;

public class Principal {

	public static void main(String[] args) {

		ThreadBilheteria tBilhete = new ThreadBilheteria();
		
		tBilhete.run();
		
	}

}
