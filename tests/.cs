public class Person {
    private string name;
    private int age;

    public Person(string name, int age) {
        this.name = name;
        this.age = age;
    }

    public void DisplayInfo() {
        Console.WriteLine("Name: " + name);
        Console.WriteLine("Age: " + age);
    }

    public string Name {
        get { return name; }
        set { name = value; }
    }

    public int Age {
        get { return age; }
        set { age = value; }
    }
}


interface IEquatable<T>
{
    bool Equals(T obj);
}

public class Car : IEquatable<Car>
{
    public string? Make { get; set; }
    public string? Model { get; set; }
    public string? Year { get; set; }

    // Implementation of IEquatable<T> interface
    public bool Equals(Car? car)
    {
        return (this.Make, this.Model, this.Year) ==
            (car?.Make, car?.Model, car?.Year);
    }
}


using System;

namespace MyNamespace
{
    public class SampleClass
    {
        public static void myMethod()
        {
            Console.WriteLine("Creating my namespace");
        }
    }
}
 
namespace MyProgram
{
    public class MyClass
    {
        public static void Main()
        {
            MyNamespace.SampleClass.myMethod();
        }
    }
}


public struct Coords
{
    public Coords(double x, double y)
    {
        X = x;
        Y = y;
    }

    public double X { get; }
    public double Y { get; }

    public override string ToString() => $"({X}, {Y})";
}
