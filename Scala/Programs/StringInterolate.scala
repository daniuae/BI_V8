object InvoiceEmailApp extends App {

  val customerName = "Ravi Kumar"
  val orderId = 3829
  val amount = 3499.75
  val productName = "NoiseFit Smartwatch"

  val message = s"Hello $customerName,\n" +
    s"Thank you for your purchase!\n\n" +
    s"Order ID: #$orderId\n" +
    s"Product: $productName\n" +
    s"Total Amount: ₹$amount\n\n" +
    s"We hope you enjoy your product!"

  println(message)
}


object InvoiceFormatted extends App {

  val customer = "Anjali"
  val total = 2100.556

  // Format to 2 decimal places
  val summary = f"Hi $customer%s, your bill is ₹$total%.2f."

  println(summary)  // Output: Hi Anjali, your bill is ₹2100.56.
}


object RawExample extends App {

  val path = "C:\\Users\\Ravi\\Documents\\invoice.pdf"

  val message = raw"Invoice saved to: $path"

  println(message)
  // Output: Invoice saved to: C:\Users\Ravi\Documents\invoice.pdf
}
