<?php

$name = "John";
$age = 30;

function greet(string $name, int $age): string {
    return "Hello, $name! You are $age years old.";
}

$fruits = ["apple", "banana", "cherry"];

$person = [
    'name' => $name,
    'age' => $age,
    'hobbies' => ['reading', 'traveling', 'coding']
];

foreach ($person['hobbies'] as $hobby) {
    echo "Hobby: $hobby\n";
}

class Person {
    private string $name;
    private int $age;
    private array $hobbies;

    public function __construct(string $name, int $age, array $hobbies = []) {
        $this->name = $name;
        $this->age = $age;
        $this->hobbies = $hobbies;
    }
    

    public function introduce(): string {
        return "Hi, I'm $this->name and I'm $this->age years old.";
    }

    public function addHobby(string $hobby): void {
        $this->hobbies[] = $hobby;
    }

    public function getHobbies(): array {
        return $this->hobbies;
    }
}

class Employee extends Person {
    private string $position;

    public function __construct(string $name, int $age, string $position, array $hobbies = []) {
        parent::__construct($name, $age, $hobbies);
        $this->position = $position;
    }

    public function introduce(): string {
        return parent::introduce() . " I work as a $this->position.";
    }
}

function divide(int $a, int $b): float {
    if ($b === 0) {
        throw new Exception("Division by zero is not allowed.");
    }
    return $a / $b;
}

$add = function(int $a, int $b): int {
    return $a + $b;
};

$square = fn($x) => $x * $x;

$john = new Employee("John Doe", 30, "Developer", ["coding", "music"]);
echo $john->introduce() . PHP_EOL;

$john->addHobby("gaming");
print_r($john->getHobbies());

try {
    echo "10 / 2 = " . divide(10, 2) . PHP_EOL;
    echo "10 / 0 = " . divide(10, 0) . PHP_EOL; // Исключение
} catch (Exception $e) {
    echo "Error: " . $e->getMessage() . PHP_EOL;
}

echo "Square of 5: " . $square(5) . PHP_EOL;

namespace MyApp;

class Example {
    public static function sayHello() {
        echo "Hello from MyApp namespace!";
    }
}

\MyApp\Example::sayHello();

?>
