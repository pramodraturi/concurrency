package multithreading.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

public class Consumer extends Thread {
	
	Queue<Integer> queue = new LinkedList<>();
	int maxCapacity;
	
	public Consumer(Queue<Integer> queue, int maxCapacity, String name ) {
		super(name);
		this.queue = queue;
		this.maxCapacity = maxCapacity;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				while(queue.isEmpty()) {
					System.out.println("Queue is empty, Consumer is waiting for Producer to produce.");
					try {
						//currentThread().wait();
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("\t\t\tConsuming Value: "+queue.remove());
				queue.notify();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

}
