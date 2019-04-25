package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

/**
 * EnumSingleTon
 * Learning
 *
 * @author WissenSolutions.
 */
public enum EnumSingleTon {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int iValue) {
        value = iValue;
    }
}
 class Test{
    public static void main(String[] args){
        EnumSingleTon singleTon = EnumSingleTon.INSTANCE;
        singleTon.setValue(123);
        Class myObjectClass = EnumSingleTon.class;
        Constructor[] constructors = myObjectClass.getDeclaredConstructors();
        System.out.println(constructors.length);
        Stream.of(constructors).forEach(iConstructor -> {
            iConstructor.setAccessible(true);
            try {
                EnumSingleTon instance = (EnumSingleTon) iConstructor.newInstance();
                System.out.println(instance.getValue());
            } catch (InstantiationException iE) {
                iE.printStackTrace();
            } catch (IllegalAccessException iE) {
                iE.printStackTrace();
            } catch (InvocationTargetException iE) {
                iE.printStackTrace();
            }
        });
    }
}
