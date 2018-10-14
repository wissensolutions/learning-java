package reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * ReflectionExample
 * Learning
 *
 * @author WissenSolutions.
 */
public class ReflectionExample {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionExample.class);

    public static void main(String[] args) throws Exception{
        Class myObjectClass = ClassA.class;
        // get the absolute name of the class
        logger.info("AbsoluteName={}",myObjectClass.getName());

        // get the simple name of the class (without package info)
        logger.info("SimpleName={}",myObjectClass.getSimpleName());

        // get the package name of the class
        logger.info("PackageName={}",myObjectClass.getPackage().getName());

        // get all the constructors of the class
        Constructor[] constructors = myObjectClass.getDeclaredConstructors();
        Stream.of(constructors).forEach(constructor->constructor.setAccessible(true));
        logger.info("Constructors={}", Arrays.toString(constructors));

        // get constructor with specific argument
        Constructor constructor = myObjectClass.getDeclaredConstructor(Integer.TYPE,String.class);
        constructor.setAccessible(true);
        ClassA instance = (ClassA) constructor.newInstance(120,"test");

        // get all methods declared in the class
        Method[] methods = myObjectClass.getMethods();
        Stream.of(methods).forEach(iMethod->{
            iMethod.setAccessible(true);
            logger.info("Method Name={}",iMethod.getName());
        });

        //Invoking some method by passing real object
        Method method = myObjectClass.getMethod("printObject",null);
        method.invoke(instance,null);


        // gets all the public member fields of the class RentCar
        Field[] fields = myObjectClass.getFields();
        Stream.of(fields).forEach(iField -> logger.info("FIELD_NAME={}",iField));

        // gets all the declared member fields of the class RentCar
        Field[] allFields = myObjectClass.getDeclaredFields();
        Stream.of(allFields).forEach(iField -> {
            iField.setAccessible(true);
            try {
                logger.info("FIELD_NAME={}, FIELD_VALUE={}",iField,iField.get(instance));
            } catch (IllegalAccessException iE) {
                iE.printStackTrace();
            }
        });



    }
}
