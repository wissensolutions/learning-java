package strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * RemoveDuplicateCharacter
 * Given a String, Remove duplicate characters from it
 *
 * @author WissenSolutions.
 */
public class RemoveDuplicateCharacter {

    @Test
    public void testRemoveDuplicateCharacter() {
        String input = "Tester ";
        Assert.assertEquals("Testr", removeDuplicateCharacterWithSet(input));
    }

    private String removeDuplicateCharacterWithSet(String word){
        Set<Character> set = new HashSet<>();
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(Character character : chars){
            if(!set.contains(character)){
                sb.append(character);
                set.add(character);
            }
        }
        return sb.toString().trim();
    }
}
