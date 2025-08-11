import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
object BasicTransformationsExample {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("BasicTransformationsExample")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._
    // Sample data
    val data = Seq(
      (1, "Anjali", 25, "IT"),
      (2, "Benny", 30, "HR"),
      (3, "Chitra", 35, "IT"),
      (4, "Dani", 40, "Finance"),
      (5, "Ella", 30, "IT")
    )
    val df = data.toDF("id", "name", "age", "dept")
    println("=== Original DataFrame ===")
    df.show()
    // 1. Select specific columns
    val selectedDF = df.select("name", "age")
    selectedDF.show()
    // 2. Add a new column
    val newColumnDF = df.withColumn("age_plus_5", col("age") + 5)
    newColumnDF.show()
    // 3. Filter rows
    val filteredDF = df.filter(col("age") > 30)
    filteredDF.show()
    println("=== filteredDF ===")
    // 4. Remove duplicates
    val distinctDF = df.select("dept").distinct()
    distinctDF.show()
    // 5. Sort data
    val sortedDF = df.orderBy(col("age").desc)
    sortedDF.show()
    // 6. Group and aggregate
    val groupedDF = df.groupBy("dept").agg(avg("age").alias("avg_age"))
    groupedDF.show()
    // 7. Join example
    val deptInfo = Seq(
      ("IT", "Building A"),
      ("HR", "Building B"),
      ("Finance", "Building C")
    ).toDF("dept", "location")
    val joinedDF = df.join(deptInfo, "dept")
    joinedDF.show()
    spark.stop()
  }
}
