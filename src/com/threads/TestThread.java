package com.threads;

public class TestThread extends Thread{
	
	static int amount =0;
	static Thread t1 ;
	@Override
	public void run() {
		cashDeposit();
		m1();
		m2();
		
		System.out.println("Dead state of "+Thread.currentThread().getName());
	}
	private void m1() {
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("M1 - completed, executed by : "+Thread.currentThread().getName());
	}
	private void m2() {
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("M2 - completed , executed by : "+Thread.currentThread().getName());
	}


	public static void main(String[] args) {
		
		t1 = new Thread(new TestThread());
		t1.start();
		cashWithdraw();
	}
	
	static void cashDeposit() {

		System.out.println("entered to the bank, waiting in queue , executed by: "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		amount = amount+10000;
				
		System.out.println("Cash deposit completed, executed by: "+Thread.currentThread().getName());
	}

	static void cashWithdraw() {
		System.out.println("entered to the atm, executed by: "+Thread.currentThread().getName());
		try {
			t1.join(1000*11);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(amount >= 10000) {
			System.out.println("Cash withdraw of "+amount+" completed, executed by: "+Thread.currentThread().getName());
			amount = amount -10000;
		}else {
			System.out.println("In sufficeint amount.....!!!");
		}
		
	}

}
