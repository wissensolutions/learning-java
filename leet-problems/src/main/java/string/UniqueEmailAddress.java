package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Wissen Solutions.
 */
public class UniqueEmailAddress {
    @Test
    public void testHealthy() {
        Assert.assertEquals(3, numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

    public int numUniqueEmails(String[] emails) {
        int count=0;
        Set<String> email = new HashSet<>();
        for(String s: emails){
            String s1 = s.substring(0,s.indexOf('@'));
            s1 = s1.replace(".","");
            s1 = s1.substring(0, s1.indexOf('+'));
            email.add(s1+s.substring(s.indexOf('@')));
        }
        return email.size();
    }

}
