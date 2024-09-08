package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBD;

public class BancoDeDados {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int i = 0; i < 21; i++) {
			Thread t = new ThreadBD(i + 1, semaforo);
			t.start();
		}
	}

}
