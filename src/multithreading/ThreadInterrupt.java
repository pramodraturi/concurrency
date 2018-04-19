package multithreading;

import java.util.Date;

public class ThreadInterrupt {

	public static void main(String[] args) {
		Thread t0 = new Thread(new Runner5());
		t0.start();
		try {
			System.out.println("Before join: @ "+ new Date());
			t0.join(2000);
			t0.interrupt();
			System.out.println("After join: @ "+ new Date());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Runner5 implements Runnable{
	
	@Override
	public void run(){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exit from run method. @ "+ new Date());
	}
	
}
