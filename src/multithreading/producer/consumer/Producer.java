package multithreading.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Producer extends Thread{
	
	Queue<Integer> queue = new LinkedList<>();
	int maxCapacity;
	
	public Producer(Queue<Integer> queue, int maxCapacity, String name) {
		super(name);
		this.queue = queue;
		this.maxCapacity = maxCapacity;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				while(queue.size() == maxCapacity) {
					System.out.println("Queue is Full, Producer thread is waiting for Consumer to consumer items... UPdated");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random random = new Random();
				int i = random.nextInt();
				queue.add(i);
				queue.notify();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Produced Value: "+i);
			}
		}
	}
	

}
