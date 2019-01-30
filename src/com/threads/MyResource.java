package com.threads;

public class MyResource {
	
 synchronized	void task1() {
	 
		System.out.println("Task1 executed "+Thread.currentThread().getName());
		try {
			//Thread.sleep(1000*20);
			wait(1000*20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(10);
		System.out.println(20);
		System.out.println(30);
		System.out.println(40);
		System.out.println(50);
		System.out.println("End of task1 by "+Thread.currentThread().getName());
	}
	
  /*static synchronized void task2() {
		System.out.println("Task2 executed "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End of task2 by "+Thread.currentThread().getName());
	}
*/	
	
	public static void main(String[] args) {
		MyResource obj1 = new MyResource();
		
		
		MyThread1 t1 = new MyThread1(obj1);
		t1.setName("T-1");
		
		MyThread1 t2 = new MyThread1(obj1);
		t2.setName("T-2");
		
		MyThread1 t3 = new MyThread1(obj1);
		t3.setName("T-3");
		
		t1.start();
		t2.start();
		t3.start();
		
	/*	
		MyResource obj2 = new MyResource();
		
		MyThread1 t4 = new MyThread1(obj2);
		t4.setName("T-4");
		
		MyThread2 t5 = new MyThread2(obj2);
		t5.setName("T-5");
		
		t4.start();
		t5.start();
		
		MyThread1 t6 = new MyThread1(obj2);
		t6.setName("T-6");
		t6.start();
		
		MyResource obj3 = new MyResource();
		
		
		MyThread1 t7 = new MyThread1(obj3);
		t7.setName("T-7");
		
		MyThread2 t8 = new MyThread2(obj3);
		t8.setName("T-8");
		
		t7.start();
		t8.start();
		*/
	/*	MyThread1 t9 = new MyThread1(obj3);
		t9.setName("T-9");
		t9.start();
*/	}

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
/*
class MyThread2 extends Thread{
	MyResource resource;
	public MyThread2(MyResource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
			resource.task2();
	}
}*/