package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ConcurrentModificationExampleWithHashMap
 * Learning
 *
 * @author WissenSolutions.
 */
public class ConcurrentModificationExampleWithHashMap {

    private Map<String,AtomicInteger> orderMap = new HashMap<>();
    private void increment(String item){
        this.orderMap.get(item).incrementAndGet();
    }
    public static void main(String[] args) throws Exception{

        ConcurrentModificationExampleWithHashMap example = new ConcurrentModificationExampleWithHashMap();
        example.orderMap.put("Item1",new AtomicInteger());
        example.orderMap.put("Item2",new AtomicInteger());
        example.orderMap.put("Item3",new AtomicInteger());
        example.orderMap.put("Item4",new AtomicInteger());
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(()->{
            int i = 0;
            while(i<10000) {
                example.increment("Item1");
                i++;
            }
        });
        service.submit(()->{
            int i = 0;
            while(i<10000) {
                example.increment("Item2");
                i++;
            }
        });
        // Waiting for 1 second and then shutting down the service
        service.awaitTermination(1, TimeUnit.SECONDS);
        service.shutdown();
        System.out.println("VALUE="+example.orderMap);

    }
}
