## Objects and Classes

**Objects :** Objects have state and behaviors. Ex, A dog has state - color, breed etc as well as behaviors - wagging the tail, barking etc.  
**Classes :** A class is a template/blueprint that describes the behavior or state of a object.

Example of class, 

```java
public class Dog {

String breed;
int ageC
String color;

void barking() { }

void hungry() { }

void sleeping() { }

}
```
A class can have any of the following variable types, 

- **Local** - Variables defined inside methods, constructors or blocks are called local variables. The variable will be declared and initialized within the method and the variable will be destroyed when the method has completed.
- **Class** - Class variables are variables declared within a class, outside any method, with the static keyword.
- **Instance** - Instance variables are variables within a class but outside any method. These variables are initialized when the class is instantiated. Instance variables can be accessed from inside any method, constructor or blocks of that particular class.

**Constructors**
When discussing about classes, one of the most important sub topic would be constructors. Every class has a constructor. If we do not explicitly write a constructor for a class, the Java compiler builds a default constructor for that class.  
Each time a new object is created, at least one constructor will be invoked. The main rule of constructors is that they should have the same name as the class. A class can have more than one constructor.

**Creating an Object**
As mentioned previously, a class provides the blueprints for objects. So basically, an object is created from a class. In Java, the new keyword is used to create new objects.
There are three steps when creating an object from a class,

- **Declaration** − A variable declaration with a variable name with an object type.
- **Instantiation** − The 'new' keyword is used to create the object.
- **Initialization** − The 'new' keyword is followed by a call to a constructor. This call initializes the new object.