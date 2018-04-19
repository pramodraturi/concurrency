package multithreading;

public class SumofNumber {
	
	public static volatile Integer counter = 0;
	public static void main(String[] args) {
		
		//IntStream.range(1, 10);
//		new Thread(new Runnable1()).start();
//		new Thread(new Runnable2()).start();
//		new Thread(new Runnable3()).start();
		
		Runnable1 runner = new Runnable1();
		new Thread(runner).start();
		new Thread(runner).start();
		new Thread(runner).start();
	}

}

class Runnable1 implements Runnable{
	
	@Override
	public void run() {
		synchronized (SumofNumber.counter) {
			for(int i=1; i <= 10; i++) {
				System.out.println(SumofNumber.counter++);
			}
		}
	}
}
