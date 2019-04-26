package math;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class CountTriplets {
    @Test
    public void testHealthy() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(5L);
        list.add(5L);
        list.add(25L);
        list.add(125L);
        //Assert.assertEquals(4, countTriplets(list, 5));

        list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(1L);
        list.add(2L);
        list.add(4L);
        Assert.assertEquals(3, countTriplets(list, 2));
    }

    private long countTriplets(List<Long> arr, long r) {
        Map<Long,Long> v2 = new HashMap<>();
        Map<Long,Long> v3 = new HashMap<>();
        Long count = 0L;
        for (Long k:arr) {
            count+=v3.get(k)==null?0:v3.get(k);
            if (v2.get(k)!=null) {
                v3.compute(k*r,(key,value)->value!=null?value+v2.get(k):v2.get(k));
            }
            v2.compute(k*r,(key,value)->value==null?1:value+1);
        }
        return count;
    }
}
