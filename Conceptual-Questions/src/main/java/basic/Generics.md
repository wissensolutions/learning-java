## Generics in Java

- Java Generic methods and generic classes enable programmers to create classes, interfaces and methods to take other classes and interfaces as type arguments.
- Generics also provide compile-time type safety that allows programmers to catch invalid types at compile time.
- Using Java Generic concept, we might write a generic method for sorting an array of objects, then invoke the generic method with Integer arrays, Double arrays, String arrays and so on, to sort the array elements.
- Below is an example of a generic class **Param** that takes a single type parameter **T**, delimited by angle brackets (**<>**):

```java
public class Param<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
```

To instantiate this class, we have to provide it with a type argument in **T's** place, e.g. **Integer** which is available from _Java SE5_:

```java
Param<Integer> integerParam = new Param<Integer>();
```

In _Java SE7_ and later, the type argument can be replaced with an empty set of type arguments (<>) called the diamond operator:
```java
Param<Integer> integerParam = new Param<>();
```

- Extending a Generic class,
```java
public class Email extends Param<String> {
    // ...
}

public class Age extends Param<Integer> {
    // ...
}

public class Height extends Param<T> {
    // ...
}
```
- Limitation of Diamond Operator **<>**  is, for anonymous classes you should provide the type parameter.
    * Although using Diamond Operator with Anonymous Classes is not supported in Java 7 and 8, it will be included as a new feature in Java 9. 
```java
// This will compile:
Comparator<String> caseInsensitiveComparator = new Comparator<String>() {
    @Override
    public int compare(String lhs, String rhs) {
        return lhs.compareToIgnoreCase(rhs);
    }
};

// But this will not:
Comparator<String> caseInsensitiveComparator = new Comparator<>() {
    @Override
    public int compare(String lhs, String rhs) {
        return lhs.compareToIgnoreCase(rhs);
    }
};
```