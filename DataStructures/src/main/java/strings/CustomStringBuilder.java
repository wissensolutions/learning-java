package strings;

import java.util.Arrays;

/**
 * CustomStringBuilder
 * Learning
 *
 * @author WissenSolutions.
 */
public class CustomStringBuilder {

    private static final int DEFAULT_CAPACITY = 1000;

    private char[] charArray;
    private int capacity;
    private int size;

    public CustomStringBuilder(int size){
        this.capacity = size;
        charArray = new char[capacity];
    }

    public CustomStringBuilder(){
        this(DEFAULT_CAPACITY);
    }

    public void append(String newString){
        if(newString == null){
            return;
        }
        char[] newCharArray = newString.toCharArray();
        // Check whether char buffer array can hold new input string
        if(size + newCharArray.length < charArray.length){
            increaseCapacity();
        }
        for(int i=0; i<newCharArray.length; i++){
            charArray[size] = newCharArray[i];
            size++;
        }

    }

    @Override
    public String toString(){
        return new String(charArray,0,size);
    }
    private void increaseCapacity(){
        charArray = Arrays.copyOf(charArray, charArray.length*2);
    }
}
