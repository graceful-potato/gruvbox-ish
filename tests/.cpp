#include <iostream>
#include <vector>
#include <string>
#include <cmath>
#include <exception>

template <typename T>
T add(T a, T b) {
    return a + b;
}

class Person {
protected:
    std::string name;
    int age;

public:
    Person(const std::string& name, int age) : name(name), age(age) {
        std::cout << "Person created: " << name << ", age " << age << "\n";
    }

    virtual ~Person() {}

    virtual std::string introduce() const {
        return "Hi, I'm " + name + " and I'm " + std::to_string(age) + " years old.";
    }

    void addHobby(const std::string& hobby) {
        hobbies.push_back(hobby);
    }

    void listHobbies() const {
        for (const auto& hobby : hobbies) {
            std::cout << "Hobby: " << hobby << "\n";
        }
    }

private:
    std::vector<std::string> hobbies;
};

class Employee : public Person {
    std::string position;

public:
    Employee(const std::string& name, int age, const std::string& position)
        : Person(name, age), position(position) {}

    std::string introduce() const override {
        return Person::introduce() + " I work as a " + position + ".";
    }
};

class Shape {
public:
    virtual double area() const = 0;
    virtual double perimeter() const = 0;
    virtual ~Shape() {}
};

class Circle : public Shape {
    double radius;

public:
    Circle(double radius) : radius(radius) {}

    double area() const override {
        return M_PI * radius * radius;
    }

    double perimeter() const override {
        return 2 * M_PI * radius;
    }
};

double divide(double a, double b) {
    if (b == 0) {
        throw std::invalid_argument("Division by zero is not allowed");
    }
    return a / b;
}

int main() {
    try {
        Person john("John", 30);
        std::cout << john.introduce() << "\n";
        john.addHobby("reading");
        john.addHobby("coding");
        john.listHobbies();

        Employee jane("Jane", 28, "Developer");
        std::cout << jane.introduce() << "\n";

        std::cout << "Sum of 3 and 4 (int): " << add(3, 4) << "\n";
        std::cout << "Sum of 3.5 and 4.5 (double): " << add(3.5, 4.5) << "\n";

        Circle circle(5.0);
        std::cout << "Circle: Area = " << circle.area()
                  << ", Perimeter = " << circle.perimeter() << "\n";

        std::cout << "10 / 2 = " << divide(10, 2) << "\n";
        std::cout << "10 / 0 = " << divide(10, 0) << "\n";
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << "\n";
    }

    std::vector<std::string> names = {"Alice", "Bob", "Charlie"};
    names.push_back("Diana");
    for (const auto& name : names) {
        std::cout << "Name: " << name << "\n";
    }

    return 0;
}
