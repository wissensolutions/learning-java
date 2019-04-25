package strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem03
 * Given a dictionary of words, and a string, tell whether
 * an input string can be completely segmented into dictionary words.
 *
 *
 * @author WissenSolutions.
 */
public class Problem03 {
    private static final Logger logger = LoggerFactory.getLogger(Problem03.class);

    private boolean canSegment(String word, Set<String> dictionary){
        char[] chars = word.toCharArray();
        if(dictionary.contains(word)){
            return true;
        } else {
            for (int i = 0; i < chars.length; i++) {

                String newWord = word.substring(i + 1);
                if (canSegment(newWord, dictionary)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("apple");
        dict.add("pear");
        dict.add("pier");
        dict.add("pie");
        System.out.println(new Problem03().canSegment( "applepie",dict));
    }
}
