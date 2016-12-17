## Arrays

- Arrays is the most basic type of data structure that stores similar kind of values. 
- Each item in a array is a element and can be accessed using a index. 
    - Normally arrays have 0 based index which means indexing starts from 0 and goes till _n - 1_ where n is the number of elements in array.
    - Arrays can have 0 based indexing, 1 based indexing or n based indexing (for negative values)
- Size of an array is fixed at runtime when initialized. It can't be changed after initialization.
- If size has to be changed after initialization, use _ArrayList_ (Collection class) instead.
- Size of an array can be specified using int only, since arrays are int based index.
- The ArrayIndexOutOfBoundsException is thrown when a non-existing index of an array is being accessed.
- Arrays are used to implement mathematical vectors and matrices, as well as other kinds of rectangular tables. 
- Many databases, small and large, consist of (or include) one-dimensional arrays whose elements are records.
- Arrays are used to implement other data structures, such as heaps, hash tables, deques, queues, stacks, strings, and VLists.
- Below is the representation, 

<img width="426" alt="screen shot 2016-08-31 at 2 21 49 pm" src="https://cloud.githubusercontent.com/assets/3439029/18146774/600b0d4a-6f86-11e6-8005-3f6da1afc95f.png">
**************************************

**Defining Arrays**
- Java offers several ways of defining and initializing arrays, including literal and constructor notations. When declaring arrays without explicit values, each element will be initialized with a default value:
    - **0** for primitive numerical types: _byte, short, char, int, long, float, and double._
    - **false** for the _boolean_ type.
    - **null** for _reference_ types.

In Java, it is possible to have arrays of size 0:
```java 
int[] array = new int[0]; // Compiles and runs fine.
```
However, since it's an empty array, no elements can be assigned to it:
```java
array[0] = 1; // Throws java.lang.ArrayIndexOutOfBoundsException.
```
Such empty arrays are typically useful as return values, so that the calling code only has to worry about dealing with an array, rather than a potential null value that may lead to a NullPointerException.
The length of an array must be a non-negative integer:
```java
int[] array = new int[-1]; // Throws java.lang.NegativeArraySizeException
```
The array size can be determined using a public final field called length:
```java
System.out.println(array.length); // Prints 0 in this case.
```
**Note:** _array.length_ returns the actual size of the array and not the number of array elements which were assigned a value, unlike ArrayList#size() which returns the number of array elements which were assigned a value.
**************************************

**Syntax**
```java
ArrayType[] variableName; // Declaring arrays
ArrayType variableName[]; // Another valid syntax (less commonly used)
ArrayType[][][] variableName; // Declaring multi-dimensional jagged arrays (repeat []s)
ArrayType myVar = array[index]; // Accessing (reading) element at index
array[index] = value; // Assign value to position index of array
ArrayType[] myArray = new ArrayType[arrayLength]; // Array initialization syntax
int[] ints = {1, 2, 3}; // Array initialization syntax with values provided, length is inferred from the number of provided values: {[value1[, value2]*]}
new int[]{4, -5, 6} // Can be used as argument, without a local variable
int[] ints = new int[3]; // same as {0, 0, 0}
int[][] ints = {{1, 2}, {3}, null}; // Multi-dimensional array initialization. int[] extends Object (and so does anyType[]) so null is a valid value.
```
**************************************

**Multi Dimensional Arrays**  
```java
int[][] a = new int[3][4]; // Creates a matrix with 3 rows and 4 columns
```
Below is the representation of multi dimensional array  

![two-dimensional-array](https://cloud.githubusercontent.com/assets/3439029/18147340/0729cd8a-6f89-11e6-841f-5ac5bf53bd02.png)

There are two orders that can exists in a multi dimensional array, i.e  
_Row major_ and _Column major_  
For ex, consider below matrix

<img width="185" alt="screen shot 2016-08-31 at 9 50 23 pm" src="https://cloud.githubusercontent.com/assets/3439029/18155706/04e2045c-6fc5-11e6-847e-8d8f406de844.png">

Here, in row-major layout, elements can be represented as **[1,2,3,4,5,6,7,8,9]** whereas in column-major layout, elements can be represented as **[1,4,7,2,5,8,3,6,9]**

**************************************

**Creating and initializing generic type arrays**  

In generic classes, arrays of generic types cannot be initiated like so due to type erasure:
```java
public class MyGenericClass<T> {
    private T[] a;

    public MyGenericClass() {
        a = new T[5]; // Compile time error: generic array creation
    }
}
```
Instead, they can be created using one of the following methods:  

**1.** By creating an Object array, and casting it to the generic type:
```java
a = (T[])new Object[5];
```
This is the simplest method, but since the underlying array is still of type Object[], this method does not provide type safety, so the array is best used only within the generic class, not exposed publicly.  

**2.** By using Array.newInstance with a class parameter:
```java
public MyGenericClass(Class<T> clazz) {
    a = (T[]) Array.newInstance(clazz, 5);
}
```
Here the class of T has to be explicitly passed to the constructor. The return type of Array.newInstance is always Object. However, the newly created array is in fact of type T[], and can be safely externalized.
**************************************

**Sorted Arrays**  

Arrays are considered to be sorted in ascending order when each element on left of that element in a array is smaller then that element itself. Vice versa goes for descending order.

**Pros:**
- Accessing an element is fast using the index - access time is O(1).
- Much faster to process - see this question.  
    
**Cons:**
- Insertion and deletion are slow, subsequent elements must be moved - complexity for insertion in that case is O(n).
- A large enough block of memory is needed to hold the array.
- Easily corrupted (data could be inserted in the middle).  

**************************************

**Arrays v/s List**

| **Property**        | **Array**           | **List**  |
| ------------- |-------------| -----|
| **Size** | _Fixed length. Cannot change the size after creation_ | _Dynamic in size. Capacity grows as the elements are added_ |
| **Content** | _Can contain primitive data types and objects_ | _Objects only. No primitive data types_ |
| **Dimension** | _Can be multi-dimensional_ | _Normally single dimensional, but can be made multi dimensional_ |
| **Type Safety** | _Typesafe, meaning that array will contain objects of specific class or primitives of specific data type_ | _Not type safe by default. Generics can be used to make a List type safe_ |
| **Insertion/Deletion** | _Shifting existing elements may be needed if action is performed not at the end of the array_ | _Easy insertion/deletion methods provided_ |
**************************************

**Operations on Arrays** 

Below operations on Arrays are implemented [here](../Arrays/BasicOperations.java)
- Iterating over arrays in regular order and reverse order
- Converting arrays to Stream
- Finding an element in array
- Getting the length of the array
- Traversing through the elements of array
- Copying/Resizing arrays
- Removing elements from arrays
- Sorting elements in a array
- Arrays as method params
- Arrays in memory
- Casting arrays
- Comparing arrays for equality
- Converting array of objects to array of primitives
- Converting arrays between primitives and boxed types
- Reversing an array

**************************************

**Comparison with other Data Structures**

<img width="972" alt="screen shot 2016-09-01 at 4 21 12 pm" src="https://cloud.githubusercontent.com/assets/3439029/18187642/2d5f48cc-7060-11e6-8a59-4affd3fdd885.png">
