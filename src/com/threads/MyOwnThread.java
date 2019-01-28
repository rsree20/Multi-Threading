package com.threads;

public class MyOwnThread extends Thread{
	
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		
		super.start();
		System.out.println("hello, I'm in start");
	}
	
	@Override
	public void run() {
		try {
			method2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("First line of main method: " + Thread.currentThread().getName());
		MyOwnThread t1 = new MyOwnThread();
		t1.run();
		method1();
	}

	private static void method1() throws InterruptedException {
		System.out.println("method1 execution started by: " + Thread.currentThread().getName());
		Thread.sleep(1000 * 5);
		System.out.println("method1 execution completed by: " + Thread.currentThread().getName());
	}

	private static void method2() throws InterruptedException {
		System.out.println("method2 executed started by: " + Thread.currentThread().getName());
		Thread.sleep(1000 * 5);
		System.out.println("method2 execution completed by: " + Thread.currentThread().getName());

	}

}
