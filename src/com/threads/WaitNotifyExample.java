package com.threads;

public class WaitNotifyExample {
	
	String name ="java";
	
	void blockExample() {
		synchronized (String.class) {

			System.out.println("I'm in block example, method execution started " + Thread.currentThread().getName());

			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("I'm in block example, method execution completed " + Thread.currentThread().getName());
		}
	}
	
	/*synchronized void task1() {
		
		System.out.println("entered to task1, moving waiting status "+Thread.currentThread().getName());
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("received notification, exit from task1 "+Thread.currentThread().getName());
	}
	
	synchronized void task2() {

		notifyAll();
		System.out.println("notified by: "+Thread.currentThread().getName());
	}
*/	
	
	
	

	public static void main(String[] args) {
		WaitNotifyExample obj1 = new WaitNotifyExample();
		
		MyTestThread t1 = new MyTestThread(new WaitNotifyExample());
		t1.setName("T1");
		
		MyTestThread t2 = new MyTestThread(new WaitNotifyExample());
		t2.setName("T2");
		
		MyTestThread t3 = new MyTestThread(new WaitNotifyExample());
		t3.setName("T3");
		
		t1.start();
		t2.start();
		t3.start();
	
		/*WaitNotifyExample obj2 = new WaitNotifyExample();
	
		MyTestThread1 t4 = new MyTestThread1(obj1);
		t4.setName("T4");
		t4.start();
	*/	
	}
}

class MyTestThread extends Thread{
	
	WaitNotifyExample obj;
	
	public MyTestThread(WaitNotifyExample obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		//obj.task1();
		
		obj.blockExample();
	}
}

/*
class MyTestThread1 extends Thread{
	
	WaitNotifyExample obj;
	
	public MyTestThread1(WaitNotifyExample obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		obj.task2();
	}
}*/