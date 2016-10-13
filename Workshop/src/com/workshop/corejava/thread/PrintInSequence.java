package com.workshop.corejava.thread;


/*
 * print series 010203040506.. using multi-threading 1st thread will print only 0 2nd thread will print only even numbers and 3rd thread print only odd numbers.
 */
public class PrintInSequence {
	public int status = 1;

	public static void main(String[] args) {
		PrintInSequence printInSequence = new PrintInSequence();

		PrintZero printZero = new PrintZero(printInSequence);
		PrintEven printEven = new PrintEven(printInSequence);
		PrintOdd printOdd = new PrintOdd(printInSequence);
		printZero.start();
		printOdd.start();
		printEven.start();
	}

}

class PrintZero extends Thread {
	PrintInSequence printInSequence;

	public PrintZero(PrintInSequence printInSequence) {
		this.printInSequence = printInSequence;
	}

	public void run() {
		try {
			synchronized (printInSequence) {
				for (int i = 0; i < 10; i++) {
					while (printInSequence.status != 1) {
						printInSequence.wait();
					}
					System.out.print(0);
					printInSequence.status=2;
					printInSequence.notifyAll();
					while (printInSequence.status != 1) {
						printInSequence.wait();
					}
					System.out.print(0);
					printInSequence.status=3;
					printInSequence.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception from thread-PrintZero");
		}

	}
}

class PrintEven extends Thread {

	PrintInSequence printInSequence;

	public PrintEven(PrintInSequence printInSequence) {
		this.printInSequence = printInSequence;
	}
	public void run() {
		try {
			synchronized (printInSequence) {
				for (int i = 2; i <10; i=i+2) {
					while (printInSequence.status != 3) {
						printInSequence.wait();
					}
					System.out.print(i);
					printInSequence.status=1;
					printInSequence.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception from thread-PrintEven");
		}

	}

}

class PrintOdd extends Thread {

	PrintInSequence printInSequence;

	public PrintOdd(PrintInSequence printInSequence) {
		this.printInSequence = printInSequence;
	}
	public void run() {
		try {
			synchronized (printInSequence) {
				for (int i = 1; i < 10; i=i+2) {
					while (printInSequence.status != 2) {
						printInSequence.wait();
					}
					System.out.print(i);
					printInSequence.status=1;
					printInSequence.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception from thread-PrintOdd");
		}

	}
	

}