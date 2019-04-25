package strings;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reverse words in a Sentence
 * Learning
 *
 * @author WissenSolutions.
 */
public class ReverseWords {
    private static final Logger logger = LoggerFactory.getLogger(ReverseWords.class);

    @Test
    public void testReverseWords(){
        String sentence = "This is a sentence";
        String reverse = "sentence a is This";
        Assert.assertEquals(reverse, reverseWordsWithSplit(sentence));
    }

    private static String reverseWordsWithSplit(String sentence){
        if(sentence == null){
            return null;
        }
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();

        for(int i = words.length-1; i>=0; i--){
            builder.append(words[i]+ " ");
        }
        return builder.toString().trim();
    }


}
