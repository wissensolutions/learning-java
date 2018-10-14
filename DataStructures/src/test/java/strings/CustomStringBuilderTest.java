package strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * CustomStringBuilderTest
 * Learning
 *
 * @author WissenSolutions.
 */
public class CustomStringBuilderTest {

    @Test
    public void customBufferTest(){
        CustomStringBuilder stringBuilder = new CustomStringBuilder();
        stringBuilder.append("Test1");
        stringBuilder.append("Test2");
        Assert.assertEquals("Test1Test2",stringBuilder.toString());
    }

    @Test
    public void customBufferTestWithNull(){
        CustomStringBuilder stringBuilder = new CustomStringBuilder();
        stringBuilder.append("Test1");
        stringBuilder.append(null);
        Assert.assertEquals("Test1",stringBuilder.toString());
    }
}
