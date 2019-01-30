package com.threads;

public class InterThreadCommunication {
	
	int amount =0;
	synchronized void cashDeposit() {
		System.out.println("entered to the bank, waiting in queue to deposit the money "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		amount= amount +10000;
		System.out.println("amount deposited, new balance is :  "+amount+"  "+Thread.currentThread().getName());
	}
	
	synchronized void withdraw() {
		
		System.out.println("waiting to withdraw the money "+Thread.currentThread().getName());
		
		
		amount = amount -5000;
		
		System.out.println("amount withdrawn, new balance is :  "+amount+"  "+Thread.currentThread().getName());
		
	}

}


