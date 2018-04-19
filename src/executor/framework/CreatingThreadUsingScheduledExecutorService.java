package executor.framework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CreatingThreadUsingScheduledExecutorService {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		for(int i =1; i< 10 ;i++) {
			Runnable runner = () -> {
				System.out.println(Thread.currentThread().getName()+": "+Thread.currentThread().getId());
			};
			scheduledExecutorService.execute(runner);
		}
		scheduledExecutorService.shutdown();
		
	}

}
