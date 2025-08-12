 
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object action3 {
    //CollectExample
    def main(args: Array[String]):  Unit ={
      val spark: SparkSession = SparkSession.builder()
        .master("local[1]")
        .appName("Spark")
        .getOrCreate()

      //3 Example Dataset
      spark.sparkContext.setLogLevel("ERROR")
      import spark.implicits._
      val salesDF = Seq(
        ("North", "2025-08-01", "ProductA", 1000),
        ("North", "2025-08-02", "ProductB", 1500),
        ("North", "2025-08-03", "ProductA", 800),
        ("South", "2025-08-01", "ProductA", 1200),
        ("South", "2025-08-02", "ProductB", 1000),
        ("South", "2025-08-03", "ProductA", 900)
      ).toDF("region", "date", "product", "amount")

  //Window Spec
      val windowSpec = Window
        .partitionBy("region")  // group rows by region
        .orderBy("date")        // sort rows in each region by date
        .rowsBetween(Window.unboundedPreceding, Window.currentRow) // cumulative

      // Examples of Window Functions
      val withCumulative = salesDF.withColumn(
        "cumulative_amount",
        sum("amount").over(windowSpec)
      )
      withCumulative.show()

  //Ranking Products by Date per Region
  val rankedDF = salesDF.withColumn(
    "rank_in_region",
    rank().over(windowSpec)
  )
      rankedDF.show()

      //Windows spec
      val windowSpec1 = Window
        .partitionBy("region")       // replace with your grouping column(s)
        .orderBy("date")             // replace with your ordering column

      val withLeadLag1 = salesDF
 
        .withColumn("prev_amount", lag("amount", 1).over(windowSpec1))
        .withColumn("next_amount", lead("amount", 1).over(windowSpec1))

      withLeadLag1.show()

 // Lead and Lag
//  val withLeadLag = salesDF
//    .withColumn("prev_amount", lag("amount", 1).over(windowSpec))
//    .withColumn("next_amount", lead("amount", 1).over(windowSpec))
//
//  withLeadLag.show()

      //Average over Last 2 Days

      val movingAvgSpec = Window
        .partitionBy("region")
        .orderBy("date")
        .rowsBetween(-1, 0) // previous row and current row

      val movingAvgDF = salesDF.withColumn(
        "2day_avg",
        avg("amount").over(movingAvgSpec)
      )
      movingAvgDF.show()

      //Using SQL Directly
      //You can also register the DataFrame as a temp view and use SQL syntax:

//    salesDF.createOrReplaceTempView("sales")
//    spark.sql("""
//    SELECT region, date, product, amount,
//     SUM(amount) OVER (PARTITION BY region ORDER BY date
//                       ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS cumulative_amount
//    FROM sales
//    """).show()


    }



}
