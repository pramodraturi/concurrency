package executor.framework;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CreatingThreadUsingExecutor {
	
	public static void main(String... args) {
		
		Executor executorInstance = Executors.newFixedThreadPool(2);
		for(int i = 1; i<= 10; i++) {
		Runnable runner = () ->  System.out.println(Thread.currentThread().getName()+ ": Hi from runner...");
		executorInstance.execute(runner);
		}
	}
	
}