public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// Declare a basic namespace
package com.mycompany.project;
 
public class MyClass {
    // Class content goes here
}

public class SomeClass {

    @Override
    public String toString() {
        return "SomeClass";
    }

    @Deprecated
    public void doSomeOperation() {
        // some operation...
    }
}


// In file Utility.java
package com.mycompany.utils;
 
public class Utility {
    public static void printMessage(String message) {
        System.out.println("Message: " + message);
    }
}
 
// In file Application.java
package com.mycompany.app;
 
import com.mycompany.utils.Utility;
 
public class Application {
    public static void main(String[] args) {
        Utility.printMessage("Hello from Application");
    }
}
