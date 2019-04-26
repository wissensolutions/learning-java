package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Wissen Solutions.
 */
public class ValidateWhetherStringAnagram {
    @Test
    public void testHealthy() {
        Assert.assertTrue(isValidAnagaram("TEST","ETST"));
        Assert.assertFalse(isValidAnagaram("TEST","EQST"));
    }

    private boolean isValidAnagaram(String word1, String word2){
        if(word1 == null || word2 == null){
            return false;
        }
        if(word1.length() != word2.length()){
            return false;
        }
        List<String> permutationList = new ArrayList<>();
        for(int i = 0; i<word1.length(); i++){
            String newWord = word1.charAt(i)+ word1.substring(0,i)+ word1.substring(i+1, word1.length());
            permutationList.add(newWord);
        }
        if(permutationList.contains(word2)){
            return true;
        }
        return false;
    }
}
