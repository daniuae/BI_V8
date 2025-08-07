object LambdaExample extends App {
  // Define a lambda that adds 1 to a given number
  val addOne = (x: Int) => x + 1

  println(addOne(10)) // Output: 11
}


object LambdaMapExample extends App {
  val numbers = List(1, 2, 3, 4, 5)

  // Double each element using a lambda
  val doubled = numbers.map(x => x * 2)

  println(doubled) // Output: List(2, 4, 6, 8, 10)
}

object ShortLambdaExample extends App {
  val numbers = List(1, 2, 3)

  // Short syntax using underscore
  val tripled = numbers.map(_ * 3)

  println(tripled) // Output: List(3, 6, 9)
}
