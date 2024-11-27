use std::f64::consts::PI;
use std::fmt;
use std::error::Error;

struct Person {
    name: String,
    age: u32,
    hobbies: Vec<String>,
}

impl Person {
    fn new(name: &str, age: u32) -> Self {
        Self {
            name: name.to_string(),
            age,
            hobbies: Vec::new(),
        }
    }

    fn introduce(&self) -> String {
        format!("Hi, I'm {} and I'm {} years old.", self.name, self.age)
    }

    fn add_hobby(&mut self, hobby: &str) {
        self.hobbies.push(hobby.to_string());
    }

    fn list_hobbies(&self) {
        for hobby in &self.hobbies {
            println!("Hobby: {}", hobby);
        }
    }
}

enum Shape {
    Circle(f64),
    Rectangle(f64, f64),
}

impl Shape {
    fn area(&self) -> f64 {
        match self {
            Shape::Circle(radius) => PI * radius * radius,
            Shape::Rectangle(width, height) => width * height,
        }
    }

    fn perimeter(&self) -> f64 {
        match self {
            Shape::Circle(radius) => 2.0 * PI * radius,
            Shape::Rectangle(width, height) => 2.0 * (width + height),
        }
    }
}

fn add<T: std::ops::Add<Output = T>>(a: T, b: T) -> T {
    a + b
}

trait Greet {
    fn greet(&self) -> String;
}

impl Greet for Person {
    fn greet(&self) -> String {
        format!("Hello, my name is {}.", self.name)
    }
}

fn divide(a: f64, b: f64) -> Result<f64, Box<dyn Error>> {
    if b == 0.0 {
        Err("Division by zero is not allowed".into())
    } else {
        Ok(a / b)
    }
}

fn main() {
    let mut john = Person::new("John", 30);
    println!("{}", john.introduce());
    john.add_hobby("reading");
    john.add_hobby("coding");
    john.list_hobbies();
    println!("{}", john.greet());

    let circle = Shape::Circle(5.0);
    let rectangle = Shape::Rectangle(4.0, 7.0);
    println!(
        "Circle: Area = {:.2}, Perimeter = {:.2}",
        circle.area(),
        circle.perimeter()
    );
    println!(
        "Rectangle: Area = {:.2}, Perimeter = {:.2}",
        rectangle.area(),
        rectangle.perimeter()
    );

    println!("Sum of integers: {}", add(3, 4));
    println!("Sum of floats: {:.2}", add(3.5, 4.5));

    match divide(10.0, 2.0) {
        Ok(result) => println!("10 / 2 = {:.2}", result),
        Err(e) => println!("Error: {}", e),
    }

    match divide(10.0, 0.0) {
        Ok(result) => println!("10 / 0 = {:.2}", result),
        Err(e) => println!("Error: {}", e),
    }

    let names = vec!["Alice", "Bob", "Charlie"];
    for (index, name) in names.iter().enumerate() {
        println!("Name #{}: {}", index + 1, name);
    }
}
