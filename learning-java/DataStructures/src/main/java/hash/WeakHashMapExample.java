package hash;

import org.mockito.Mockito;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Condition;

/**
 * WeakHashMapExample
 * Learning
 *
 * @author WissenSolutions.
 */
public class WeakHashMapExample {

    public static void main(String[] args) throws Exception{
        Map<WeakReference<String>,WeakReference<Integer>> weakMap = new WeakHashMap<>();
        weakMap.put(new WeakReference<>("Test"),new WeakReference<>(1));

        if (!weakMap.isEmpty()) {
            System.out.println("Map is not Empty");
        }
        System.gc();
        System.runFinalization();
        //Thread.sleep(1000);

        if (weakMap.size()==0) {
            System.out.println("Map is  Empty");
        }

    }

    private static class Employee{
        private String id;

        public Employee(String iId) {
            id = iId;
        }
    }
}
