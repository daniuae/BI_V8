object HigherOrderFunctionsDemo {
  // A higher order function that takes another function 'f' and an integer 'x'
  // It applies 'f' to 'x' and returns the result
  /*
applyFunction is a higher order function because it takes a function f as a parameter and applies it to an integer x.
increment is a simple function to add 1 to a number.
createMultiplier returns a function that multiplies any input by factor, demonstrating that HOFs can return functions.
Inside main, various uses of these HOFs are demonstrated.
The map, filter, and reduce functions are standard Scala collection HOFs that apply a function to each element, filter elements by a condition, and combine elements respectively.
  */
  def applyFunction(f: Int => Int, x: Int): Int = {
    f(x)
  }

  // A simple function that increments an integer by 1
  def increment(n: Int): Int = n + 1

  // A higher order function that returns a function, which multiplies input by a given factor
  def createMultiplier(factor: Int): Int => Int = {
    (x: Int) => x * factor
  }

  def main(args: Array[String]): Unit = {
    // Using applyFunction to apply increment function
    val result1 = applyFunction(increment, 5)
    println(s"Increment 5: $result1")   // Output: Increment 5: 6

    // Using applyFunction with an anonymous function that doubles the input
    val result2 = applyFunction(x => x * 2, 7)
    println(s"Double 7: $result2")     // Output: Double 7: 14

    // Creating a multiplier function using higher order function
    val multiplyBy3 = createMultiplier(3)
    val result3 = multiplyBy3(10)
    println(s"10 multiplied by 3: $result3")  // Output: 10 multiplied by 3: 30

    // Using standard higher order functions on collections
    val nums = List(1, 2, 3, 4, 5)

    // map applies a function to each element: doubling each number
    val doubled = nums.map(_ * 2)
    println(s"Doubled List: $doubled")  // Output: Doubled List: List(2, 4, 6, 8, 10)

    // filter selects elements satisfying a predicate: even numbers only
    val evens = nums.filter(_ % 2 == 0)
    println(s"Even Numbers: $evens")    // Output: Even Numbers: List(2, 4)

    // reduce combines elements using a binary operation: sum of all numbers
    val sum = nums.reduce(_ + _)
    println(s"Sum of List: $sum")       // Output: Sum of List: 15
  }
}
