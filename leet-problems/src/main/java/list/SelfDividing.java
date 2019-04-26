package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Wissen Solutions.
 */
public class SelfDividing {
    @Test
    public void testHealthy() {
        List<Integer> list = selfDividingNumbers(1, 22);
        System.out.println(list.toString());
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = left; i<=right; i++){

            if(i<10){
                list.add(i);
                map.put(i, true);
            } else if(isSelfDividable(i, map)){
                list.add(i);
            }
        }
        return list;
    }
    private boolean isSelfDividable(int num, Map<Integer, Boolean> map){
        if(num % 10 == 0){
            return false;
        }
        int x = num;

        while(x != 0){
            int r =  x % 10;
            if( num % r != 0 ){
                return false;
            }
            map.put(x, true);
            x = x /10;
            Boolean isExist = map.get(x);
            if(isExist != null && !isExist){
                return false;
            }
        }
        return true;
    }

}
