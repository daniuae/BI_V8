//WSAM
object RightAssociativeExample extends App {

  // Step-by-step creation of list using right-associative operator ::
  val myList = 1 :: 2 :: 3 :: Nil

  // Explanation output
  println("Constructed List using infix notation: " + myList)

  // Manual desugaring of the expression
  val manualList = 1 :: (2 :: (3 :: Nil))
  println("Manual List using nested :: calls: " + manualList)

  // Checking equality
  println("Are both lists equal? " + (myList == manualList))
}
