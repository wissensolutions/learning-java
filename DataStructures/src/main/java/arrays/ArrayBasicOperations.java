/**
 * arrays
 * <p>
 */
package arrays;


import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class to hold implementation of basic operations in java
 * <p> Perform following basic operations on Arrays
 * 1. Declare Array
 * 2. Insert elements in Array. ex. 3, 5, 6, 13, 45, 56, 67, 78, 89, 90
 * 3. Iterating over arrays in regular order and reverse order
 * 4. Converting arrays to Stream
 * 5. Finding an element in array
 * 6. Getting the length of the array
 * 7. Copying/Resizing arrays
 * 8. Removing elements from arrays
 * 9. Sorting elements in a array
 * 10. Arrays as method params
 * 11. Arrays in memory
 * 12. Casting arrays
 * 13. Comparing arrays for equality
 * 14. Converting array of objects to array of primitives
 * 15. Converting arrays between primitives and boxed types
 * 16. Reversing an array
 *
 */
public class ArrayBasicOperations {
    private static final Logger logger = LoggerFactory.getLogger(ArrayBasicOperations.class);
    @Test
    public void declareArray(){
        //Declare Array
        int[] array = new int[10];

        //Declare Array using list of elements
        int[] arrayElements = new int[]{3, 5, 6, 13, 45, 56, 67, 78, 89, 90};

        //Declare 2 dimensional array
        int[][] twoDimenstionalArray = new int[][]{{1,2,4},{32,45}};

        //Iterating elements in regular order
        for(int i=0; i<arrayElements.length; i++){
            logger.info("Element at {}th index is {}",i,arrayElements[i]);
        }

        //Iterating elements using java 8 Streams in regular order
        Arrays.stream(arrayElements).forEach(element -> logger.info("Element = {}",element));

        //Printing the array using Arrays
        //Iterating in reverse order
        for(int i=arrayElements.length-1; i>0; i--){
            logger.info("Element at {}th index is {}",i,arrayElements[i]);
        }

        //Iterating 2 dimensional order
        for(int i=0; i<twoDimenstionalArray.length; i++){
            for(int j=0; j<twoDimenstionalArray[i].length; j++){
                logger.info(" Column(i)={} Row(j)={} element={}",i,j,twoDimenstionalArray[i][j]);
            }
        }

        /* Approach1:Finding an element in array */
        int index = -1;
        int element = 56;
        for(int i=0; i<arrayElements.length; i++){
            if(element == arrayElements[i]){
                index = i;
                break;
            }
        }
        Assert.assertEquals(5,index);

        //Approach2: Finding an element using binary search
        Assert.assertEquals(5,Arrays.binarySearch(arrayElements,element));

		/* Approach 3 : Using a list for Non-Primitive arrays only */
		String[] names = new String[]{"a","b","c","d","e"};
        Assert.assertEquals(2,Arrays.asList(names).indexOf("c"));

        /* Approach 4 : Using a stream for Non-Primitive arrays only */
        int returnVal = IntStream.range(0,arrayElements.length).filter(i-> element == arrayElements[i]).findAny().orElse(-1);
        Assert.assertEquals(5,returnVal);

        //Copying an Array
        //Approach:1
        int[] copyArray = new int[arrayElements.length];
        for(int i=0; i<arrayElements.length; i++){
            copyArray[i] = arrayElements[i];
        }

        //Approach2 : using clone
        int[] cloneArray = arrayElements.clone();
        logger.info("Clone array = {}",Arrays.toString(cloneArray));
        Assert.assertArrayEquals(arrayElements,cloneArray);

        //Approach3 : using Arrays.Copy
        int[] copyArrayUsingArrays = Arrays.copyOf(arrayElements,arrayElements.length);
        logger.info("Clone array = {}",Arrays.toString(copyArrayUsingArrays));
        Assert.assertArrayEquals(arrayElements,copyArrayUsingArrays);

        //Approach4 : using System.array
        int[] copyArrayUsingSystemArrays = new int[arrayElements.length];
         System.arraycopy(arrayElements,0,copyArrayUsingSystemArrays,0,arrayElements.length);
        logger.info("Clone array = {}",Arrays.toString(copyArrayUsingSystemArrays));
        Assert.assertArrayEquals(arrayElements,copyArrayUsingSystemArrays);
    }
}
