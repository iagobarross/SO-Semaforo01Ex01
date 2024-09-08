package controller;

import java.util.concurrent.Semaphore;

public class ThreadBD extends Thread {

	private static Semaphore semaforo;
	private int idThread;
	private int tempoCalc;
	private int tempoTrans;

	public ThreadBD(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		calc();
		try {
			semaforo.acquire();
			trans();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
	}

	private void calc() {

		if (idThread % 3 == 1) {

			for (int i = 0; i < 2; i++) {
				tempoCalc = (int) ((Math.random() * 801) + 200);
				System.out.println("A thread #" + idThread + " realizou cálculos por: " + (double) tempoCalc / 1000
						+ " segundos.\n");
				try {
					sleep(tempoCalc);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
		} else if (idThread % 3 == 2) {
			for (int i = 0; i < 3; i++) {
				tempoCalc = (int) ((Math.random() * 1001) + 500);
				System.out.println("A thread #" + idThread + " realizou cálculos por: " + (double) tempoCalc / 1000
						+ " segundos.\n");
				try {
					sleep(tempoCalc);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}

		} else {
			for (int i = 0; i < 3; i++) {
				tempoCalc = (int) ((Math.random() * 1001) + 1000);
				System.out.println("A thread #" + idThread + " realizou cálculos por: " + (double) tempoCalc / 1000
						+ " segundos.\n");
				try {
					sleep(tempoCalc);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

			}
		}

	}

	private void trans() {
		if (idThread % 3 == 1) {
			tempoTrans = 1000;
			for (int i = 0; i < 2; i++) {
				System.out.println("A thread #" + idThread + " realizou transações por: " + (double) tempoTrans / 1000
						+ " segundos.\n");

				try {
					sleep(tempoTrans);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		} else if (idThread % 3 == 2 || idThread % 3 == 0) {
			tempoTrans = 1500;
			for (int i = 0; i < 3; i++) {
				System.out.println("A thread #" + idThread + " realizou transações por: " + (double) tempoTrans / 1000
						+ " segundos.\n");

				try {
					sleep(tempoTrans);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}

		}
	}
}
