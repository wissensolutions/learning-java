## Method overloading v/s Method overriding

**Method Overloading** 
- Having multiple copies of a method with same name but different signature is called overloading.
- All of these multiple copies should be in same class.
- This is example of compile time polymorphism.
- Ex. Below 2 methods shows how method overloading is achieved
    - ```computeArea(int length, int breadth);```
    - ```computeArea(int length, int breadth, int height);``` 
    
**Method Overriding**
- Having multiple copies of a method with same name, same number of arguments but different implementations.
- These multiple copies should be in different classes, mainly one in parent class and other one in child class. 
- However ```@Override``` annotation is not required but strongly recommended to enforce proper overriding of a method during compile time.
- This is example of runtime polymorphism.
- Static methods cannot be overriden, because static methods have class scope and not instance(Object) scope.
- Below example shows the implementation,

```java
class Parent {

	void foo(int i) {
		// do something
	}
}

class Child extends Parent {

	@Override
	void foo(int i) {
		// do something else
	}
}
```