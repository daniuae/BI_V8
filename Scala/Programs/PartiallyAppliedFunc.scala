object PartialFunctionExample extends App {
  def multiply(a: Int, b: Int): Int = a * b

  // Partially apply multiply by fixing 'a' as 5
  val multiplyBy5 = multiply(5, _: Int)

  println(multiplyBy5(10))  // Output: 50
  println(multiplyBy5(3))   // Output: 15
}

object LoggingExample extends App {
  def logMessage(date: String, message: String): Unit =
    println(s"$date - $message")

  val currentDate = "2025-08-07"
  val logToday = logMessage(currentDate, _: String)

  logToday("Service started")
  logToday("User logged in")
}

object ETLLogger extends App {
  def log(stage: String, msg: String): Unit =
    println(s"[$stage] $msg")

  val extractLog = log("EXTRACT", _: String)
  val transformLog = log("TRANSFORM", _: String)

  // Usage
  extractLog("Started reading source files")
  transformLog("Normalized customer data")
}
