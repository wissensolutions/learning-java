## Heap v/s Stack in Java

- Stack memory is used to store local variables and method calls whereas heap memory is used to store objects in java.
- No matter where the object is created in code i.e local variable or class variable, it will be stored in heap.
- Size of stack memory is lot lesser as compared to size of heap.
- If you use recursion in which method calls itself, you will quickly fill the stack memory.
- Variables stored in stack are only visible to the parent thread whereas variables stored in heap are visible to all the threads.
- Stack is a kind of private memory in java, whereas heap is a shared memory among all threads.
- Different threads share same heap but different stacks. Each thread has its own stack.
- You can increase or change size of Java Heap space by using JVM command line option -Xms, -Xmx and -Xmn.
- Don't forget to add word "M" or "G" after specifying size to indicate Mega or Gig. for example you can set java heap size to 258MB by executing following command java -Xmx256m HelloWord
- You can use command "jmap" to take Heap dump in Java and "jhat" to analyze that heap dump.
- Java Garbage collector is responsible for reclaiming memory from dead object and returning to Java Heap space.