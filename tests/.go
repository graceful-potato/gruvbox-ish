package main

import (
	"errors"
	"fmt"
	"math"
)

type Person struct {
	Name    string
	Age     int
	Hobbies []string
}

func (p *Person) Introduce() string {
	return fmt.Sprintf("Hi, I'm %s and I'm %d years old.", p.Name, p.Age)
}

func (p *Person) AddHobby(hobby string) {
	p.Hobbies = append(p.Hobbies, hobby)
}

type Employee struct {
	Person
	Position string
}

func (e *Employee) Introduce() string {
	return fmt.Sprintf("%s I work as a %s.", e.Person.Introduce(), e.Position)
}

func divide(a, b float64) (float64, error) {
	if b == 0 {
		return 0, errors.New("division by zero is not allowed")
	}
	return a / b, nil
}

func multiplier(factor int) func(int) int {
	return func(x int) int {
		return x * factor
	}
}

type Shape interface {
	Area() float64
	Perimeter() float64
}

type Circle struct {
	Radius float64
}

func (c Circle) Area() float64 {
	return math.Pi * c.Radius * c.Radius
}

func (c Circle) Perimeter() float64 {
	return 2 * math.Pi * c.Radius
}

func main() {
	john := Person{
		Name:    "John",
		Age:     30,
		Hobbies: []string{"reading", "traveling"},
	}
	fmt.Println(john.Introduce())

	john.AddHobby("coding")
	fmt.Println("Hobbies:", john.Hobbies)

	employee := Employee{
		Person:   john,
		Position: "Developer",
	}
	fmt.Println(employee.Introduce())

	result, err := divide(10, 2)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("10 / 2 =", result)
	}

	timesTwo := multiplier(2)
	fmt.Println("5 * 2 =", timesTwo(5))

	circle := Circle{Radius: 5}
	fmt.Printf("Circle: Area = %.2f, Perimeter = %.2f\n", circle.Area(), circle.Perimeter())

	for i, hobby := range john.Hobbies {
		fmt.Printf("Hobby #%d: %s\n", i+1, hobby)
	}
}
