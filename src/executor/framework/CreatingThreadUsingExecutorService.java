package executor.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreatingThreadUsingExecutorService {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for(int i =1; i< 10 ;i++) {
			Runnable runner = () -> {
				System.out.println(Thread.currentThread().getName()+": "+Thread.currentThread().getId());
			};
			executorService.execute(runner);
		}
		executorService.shutdown();
		
	}

}
