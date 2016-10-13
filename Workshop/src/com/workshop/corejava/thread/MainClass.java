package com.workshop.corejava.thread;

class ZeroTh extends Thread{
	Integer num;
	Thread t;
	public ZeroTh(Thread t) {
		this.t=t;
	}
	public void run(){
		for(int i=0;i<20;i++){
			if(i%2!=0)
				System.out.print(i);
				try {
					t.join();
					
					t.interrupt();
				} catch (InterruptedException e) {
					
				}
		}
	}
}

class evenTh extends Thread{
	Integer num;
	Thread t;
	public evenTh(Thread t) {
		this.t=t;
	}
	public void run(){
		
	}
}
class oddTh extends Thread{
	Thread t;
	public oddTh(Thread t) {
		this.t=t;
	}
	public void run(){
		
	}
}
public class MainClass {
	Integer num=100;
	public static void main(String[] args) {
		Thread t0=new ZeroTh(Thread.currentThread() );
		t0.start();
		for(int i=0;i<20;i++){
			System.out.println(0);
			try {
				t0.join();
				t0.interrupt();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		Thread te=new ZeroTh(t0 );
		t0.start();
		
		/*
		t0.start();
		Thread t0=new ZeroTh(Thread t );
		t0.start();*/
		
	}
}
