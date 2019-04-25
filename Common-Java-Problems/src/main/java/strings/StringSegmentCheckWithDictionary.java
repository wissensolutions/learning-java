package strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * StringSegmentCheckWithDictionary
 * Learning
 *
 * Method to check if a string can be segmented to a given words in dict
 *
 * @author WissenSolutions.
 */
public class StringSegmentCheckWithDictionary {
    @Test
    public void testStringSegmentCheckWithDictionary() {
        Set<String> dict = new HashSet<>();
        dict.add("apple");
        dict.add("pear");
        dict.add("pier");
        dict.add("pie");
        Assert.assertTrue(canSegmentStringWithDictionary(dict, "applepie"));
    }

    private boolean canSegmentStringWithDictionary(Set<String> dictionary, String word){
        if(word == null){
            return false;
        }
        if(dictionary.contains(word)){
            return true;
        }
        for(int i = 0; i<word.length(); i++){
            String first = word.substring(0, i);
            String second = word.substring(i,word.length());
            if(dictionary.contains(first) || dictionary.contains(second)){
                return true;
            }
        }
        return false;
    }


}
