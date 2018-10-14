Reflection allows instantiation of classes, invoking of methods and get/set operations on class variables without 
knowing the implementation of class

Popular usage of Reflection API:
1. Servlet container creates servlet object by using class names declared in web.xml
2. Spring container creates beans using this reflection API only
3. Most of data mappers uses this reflection API
4. Debuggers and code coverage tools uses it

Pros:

Cons:
1. **Performance Overhead**:  As types are required to resolve the fileds dynamically, its overhead for performance
2. **Security**: Reflection requires security permission for using it. We may not get permission when we have security manager. For ex: Applet programming
3. **Exposure of internals**: its kind of breaching encapsulation. Private variables and methods can be accessed and change the value. So it will break the 
abstraction and may cause behavior of the program

 - [Example](./ReflectionExample.java)