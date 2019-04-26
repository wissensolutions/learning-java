package string;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author : Wissen Solutions.
 */
public class Test1 {
    @Test
    public void testHealthy() throws Exception {
        int val1 = CompletableFuture.supplyAsync(()-> {
            System.out.println("test1"+LocalDateTime.now());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException iE) {
                iE.printStackTrace();
            }
            return 2;
        } ).get(5, TimeUnit.SECONDS);
        System.out.println("test4"+LocalDateTime.now());
        int val2 =CompletableFuture.supplyAsync(()-> {
            System.out.println("test2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException iE) {
                iE.printStackTrace();
            }
            return 2;
        } ).get(2, TimeUnit.MILLISECONDS);
        System.out.println("test3"+LocalDateTime.now());
    }

}
