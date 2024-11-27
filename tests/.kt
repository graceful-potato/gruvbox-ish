open class Person(val name: String, var age: Int) {
  var hobbies: MutableList<String> = mutableListOf()

  init {
    println("Person initialized: $name, age $age")
  }

  constructor(name: String, age: Int, hobbies: List<String>) : this(name, age) {
    this.hobbies.addAll(hobbies)
  }

  open fun introduce(): String {
    return "Hi, I'm $name and I'm $age years old."
  }

  fun addHobby(hobby: String) {
    hobbies.add(hobby)
  }
}

class Employee(name: String, age: Int, val position: String) : Person(name, age) {
  override fun introduce(): String {
    return "${super.introduce()} I work as a $position."
  }
}

interface Shape {
  fun area(): Double
  fun perimeter(): Double
}

class Circle(private val radius: Double) : Shape {
  override fun area(): Double = Math.PI * radius * radius
  override fun perimeter(): Double = 2 * Math.PI * radius
}

fun greet(name: String = "Guest", age: Int = 0): String {
  return "Hello, $name! You are $age years old."
}

fun processNumbers(numbers: List<Int>, operation: (Int) -> Int): List<Int> {
  return numbers.map(operation)
}

fun divide(a: Int, b: Int): Int {
  if (b == 0) throw IllegalArgumentException("Division by zero is not allowed")
  return a / b
}

fun main() {
  val john = Person("John", 30, listOf("reading", "traveling"))
  println(john.introduce())
  john.addHobby("coding")
  println("Hobbies: ${john.hobbies}")

  val employee = Employee("Jane", 28, "Developer")
  println(employee.introduce())

  val circle = Circle(5.0)
  println("Circle: Area = ${circle.area()}, Perimeter = ${circle.perimeter()}")

  println(greet())
  println(greet("Alice", 25))

  val numbers = listOf(1, 2, 3, 4, 5)
  val doubledNumbers = processNumbers(numbers) { it * 2 }
  println("Doubled numbers: $doubledNumbers")

  try {
    println("10 / 2 = ${divide(10, 2)}")
    println("10 / 0 = ${divide(10, 0)}")
  } catch (e: IllegalArgumentException) {
    println("Error: ${e.message}")
  }

  for ((index, hobby) in john.hobbies.withIndex()) {
    println("Hobby #${index + 1}: $hobby")
  }

  val names = mutableListOf("Alice", "Bob", "Charlie")
  names.add("Diana")
  println("Names: $names")
}
