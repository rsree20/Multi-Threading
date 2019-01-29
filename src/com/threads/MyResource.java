package com.threads;

public class MyResource {
	
	void task1() {
		System.out.println("task1 executed "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task1 --> "+this.hashCode());
	}
	void task2() {
		System.out.println("task2 executed "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task2 --> "+this.hashCode());
	}
	
	
	public static void main(String[] args) {
		MyResource resource = new MyResource();
		
		
		MyThread1 t1 = new MyThread1(resource);
		t1.setName("Java");
		t1.start();
		
		MyThread2 t2 = new MyThread2(resource);
		t2.setName("hibernate");
		t2.start();
	}

}

class MyThread1 extends Thread{
	MyResource resource;
	public MyThread1(MyResource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
			resource.task1();
	}
}

class MyThread2 extends Thread{
	MyResource resource;
	public MyThread2(MyResource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
			resource.task2();
	}
}