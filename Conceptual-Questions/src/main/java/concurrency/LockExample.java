package concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * LockExample
 * Learning
 *
 * @author WissenSolutions.
 */
public class LockExample {
    private static final Logger logger = LoggerFactory.getLogger(LockExample.class);
    private  int count = 0;
    Lock reentrantLock = new ReentrantLock();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public static void main(String[] args) throws Exception{
        LockExample lockExample = new LockExample();


        lockExample.testWithoutExecutorService(lockExample);
        lockExample.testWithExecutorService(lockExample);
        lockExample.testWithExecutorServiceAndSynchronizedMethod(lockExample);
        lockExample.testWithExecutorServiceAndSynchronizedBlock(lockExample);
        lockExample.testWithExecutorServiceAndRetrantBlock(lockExample);
        lockExample.testWithExecutorServiceAndWriteLock(lockExample);
        lockExample.testWithExecutorServiceAndReadLock(lockExample);
    }
    private void testWithoutExecutorService(LockExample iLockExample){
        IntStream.range(0,10000).forEach(i-> iLockExample.increment());
        logger.info("Printing the value without any executor service. Count={}", count);
    }

    private void testWithExecutorService(LockExample iLockExample) throws Exception{
        count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0,10000).forEach(value -> executorService.submit(iLockExample::increment));
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        logger.info("Printing the value with any executor service. Count={}", count);
        executorService.shutdown();
    }

    private void testWithExecutorServiceAndSynchronizedMethod(LockExample iLockExample)throws Exception{
        count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0,10000).forEach(i-> executorService.submit(iLockExample::incrementSync));
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        logger.info("Printing the value with any executor service and synchronized method. Count={}", count );
        executorService.shutdown();
    }

    private void testWithExecutorServiceAndSynchronizedBlock(LockExample iLockExample)throws Exception{
        count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0,10000).forEach(i-> executorService.submit(iLockExample::incrementSyncBlock));
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        logger.info("Printing the value with any executor service and synchronized block. Count={}", count );
        executorService.shutdown();
    }

    private void testWithExecutorServiceAndRetrantBlock(LockExample iLockExample) throws Exception{
        count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0,10000).forEach(i-> executorService.submit(iLockExample::incrementWithRetrant));
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        logger.info("Printing the value with any executor service and reetrant lock. Count={}", count );
        executorService.shutdown();
    }

    private void testWithExecutorServiceAndWriteLock(LockExample iLockExample) throws Exception{
        count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0,10000).forEach(i-> executorService.submit(iLockExample::incrementWithWriteLock));
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        logger.info("Printing the value with any executor service and write lock. Count={}", count );
        executorService.shutdown();
    }

    private void testWithExecutorServiceAndReadLock(LockExample iLockExample) throws Exception{
        count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0,10000).forEach(i-> executorService.submit(iLockExample::incrementWithReadLock));
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        logger.info("Printing the value with any executor service and read lock. Count={}", count );
        executorService.shutdown();
    }


    private void increment(){
        count = count+1;
    }

    synchronized void incrementSync(){
        count = count+1;
    }

    void incrementSyncBlock(){
        synchronized (this) {
            count = count+1;
//            logger.info("count={}",syncBlockCount);
        }
    }
    void incrementWithRetrant(){
        reentrantLock.lock();
        try{
            count = count+1;
        } finally {
            reentrantLock.unlock();
        }
    }

    void incrementWithWriteLock(){
        readWriteLock.writeLock().lock();
        try{
            count = count +1;
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    void incrementWithReadLock(){
        readWriteLock.readLock().lock();
        try{
            count = count +1;
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
