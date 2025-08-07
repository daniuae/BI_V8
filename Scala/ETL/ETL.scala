import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SparkETL {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("ETL").master("local[*]").getOrCreate()

    val df = spark.read.option("header", true).csv("orders.csv")

    val result = df
      .groupBy("product_id")
      .agg(sum("amount").as("total_amount"))
      .filter(col("total_amount") > 35000)
      .limit(50)

    result.show()
  }
}
