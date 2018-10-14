package concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * SemaphoreExample
 * Learning
 *
 * @author WissenSolutions.
 */
public class SemaphoreExample {
    private static final Logger logger = LoggerFactory.getLogger(SemaphoreExample.class);
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        SemaphoreExample example = new SemaphoreExample();
        Semaphore singleSemaphore = new Semaphore(1);
        Semaphore multiplePoolSemaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0,10000).forEach(item-> executorService.submit(()-> example.increment(singleSemaphore)));
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
        logger.info("Printing Count with single pool semaphore={}",count);

        ExecutorService multiService = Executors.newFixedThreadPool(10);
        IntStream.range(0,10000).forEach(item-> multiService.submit(()-> example.increment(multiplePoolSemaphore)));
        multiService.awaitTermination(10, TimeUnit.SECONDS);
        multiService.shutdown();
        logger.info("Printing Count with multipool semaphore={}",count);

    }

    private void increment(Semaphore iSemaphore) {
        try {
            iSemaphore.acquire();
            count = count + 1;
            iSemaphore.release();
        } catch (InterruptedException ex){
            logger.error(" Not able to acquire lock. AVAILABLE_PERMITS={}"+iSemaphore.availablePermits());
        }
    }

}
