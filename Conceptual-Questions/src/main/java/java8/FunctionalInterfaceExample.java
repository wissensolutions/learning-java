package java8;

/**
 * Functional Interfaces:
 * 1. Functional interface is an interface which will have only one single abstract method and any number of default & static methods
 * 2. Use- case: To facilitate lambda expressions and method reference expressions
 * 3. Usage :
 *      FunctionalInterfaceExample reference = (iName) -> System.out.println("Hurry , I am in functional interface method and my name="+iName);
 */
@FunctionalInterface
public interface FunctionalInterfaceExample {
    void testMe(String iName);
    default void printMyName(){
        System.out.println("MyName");
    }
    static void testStatic(){
        System.out.println("Test Static");
    }
}

