## Executors:
- If we want to decouple task execution flow from main execution flow, then we will go for executors
- Executors is basically an interface. It provides object which executes submitted tasks
- It will not mandate the execution to be asynchronous. 
- Sample Executors implementation is as below
    -  [NewThreadExecutor](../Conceptual-Questions/src/main/java/concurrency/NewThreadExecutor.java)
    -  [SampleThreadExecutor](../Conceptual-Questions/src/main/java/concurrency/SampleRunnableExecutor.java)
## Executor-service
ExecutorService is sub interface for Executor interface
Main difference between ES and Executor: 
    - ES is providing options to close submitted tasks via shutdown() and shutdownNow()
    - Executor has void method execute(Runnable ) where as ES has submit() with Future return type
    - excute method can support only Runnable. But ES's submit() will support both runnable and callable methods
   
 More information is available in 
 http://www.baeldung.com/java-executor-service-tutorial
 
![alt text](../resources/ExecutorAndExecutorServiceInJava.png "Difference between Executor and Executor-service")

## Lock 
 Introduced in Java 1.5 
 
 Main difference between Synchronized vs Lock
 - Synchronized is fully contained with in method. But where as Lock Api's lock() and unlock() can be there in any methods
 - In Synchronization, any thread will get lock. i.e no fairness. But where as lock will provide access mainly long blocking thread
 - trylock: Lock will provide tryLock api. If thread couln't get lock, then it doesn't get blocked
 - lockInteruptibly(): it will interrupted running thread and will get lock for new thread
 
 More Information : http://www.baeldung.com/java-concurrent-locks
 - [LockExample](../Conceptual-Questions/src/main/java/concurrency/LockExample.java)
 
 ## Semaphore
 Introduced in Java 1.5 
 Main Difference between Lock and Semaphore 
 - Lock will allow only one thread
 - Semaphore will allow multiple threads based on declared pool
 - [Semaphore Example](./SemaphoreExample.java)
 
 ## Thread Factory
 Its factory object which supplies thread. It avoids using hardcoding of new thread creation
 - [Simple Thread Factory Example](./SimpleThreadFactory.java)
 
 Guava provides some builder classes to create ThreadFactory and option to set prefix 
 ` new ThreadFactoryBuilder().setNameFormat(iPrefix).build());  `

 
 ## BlockingQueue
 Blocking queue is the queue which keeps blocks in below ways
 - Producer blocks if the queue is full to produce message to queue
 - Consumer blocks until item available for consumer to receive message from Queue
 
 Types of Blocking queues:
 - Bounded
 - Unbounded: 
 
 Popular blocking queue implemenations 
 - LinkedBlockingQueue
 - ArrayBlockingQueue
 
 ## TransferQueue
 Produer may wait for consumers to acknowledge. It has methods to support this
 For ex: transfer(), tryTransfer
 
 ## ConcurrentMap
 Map supports ThreadSafety operations
 Difference between ConcurrentHashMap vs Collections.Synchronized
 1. Both are supporting thread safety operations
 2. ConcurrentHashMap will apply lock only on particular portion of Map. But where as Collections.synchronizedMap will apply
  lock on whole map
 3. Concurrent updates/removal will throw ConcurrentModificationException in Collections.synchronizedMap. 
 But where as ConcurrentHashMap will not throw any exception
 
 https://www.pixelstech.net/article/1394026282-ConcurrentHashMap-vs-Collections-synchronizedMap%28%29
 
 
 
 
 
 
