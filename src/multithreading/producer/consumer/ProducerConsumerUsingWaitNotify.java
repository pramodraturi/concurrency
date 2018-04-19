package multithreading.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerUsingWaitNotify {

	static Queue<Integer> queue = new LinkedList<>();
	static int capacity = 5;
	
	public static void main(String[] args) {
		
		Producer producer  = new Producer(queue, capacity, "PRODUCER");
		Consumer consumer  = new Consumer(queue, capacity, "CONSUMER");
		
		producer.start();
		consumer.start();
		
	}
}
