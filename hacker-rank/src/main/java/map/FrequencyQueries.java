package map;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class FrequencyQueries {
    @Test
    public void testHealthy() {
        List list = Arrays.asList(Arrays.asList(1,1),Arrays.asList(2,2),Arrays.asList(3,2),Arrays.asList(1,1), Arrays.asList(1,1),Arrays.asList(2,1),Arrays.asList(3,2));

        Assert.assertEquals( "[0, 1]",freqQuery(list).toString());
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        queries.forEach(list ->{
            Integer operation = list.get(0);
            Integer element = list.get(1);
            switch (operation){
                case 1 :
                    countMap.compute(element, (k,v)-> v == null ? 1: v+1);
                    break;
                case 2 :
                    countMap.computeIfPresent(element, (k,v)-> v == 1 ? countMap.remove(k): v-1);
                    break;
                case 3 :
                    if(countMap.containsValue(element)){
                        output.add(1);
                    } else {
                        output.add(0);
                    }
            }
        });
        return output;
    }
}
