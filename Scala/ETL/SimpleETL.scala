// src/main/scala/SimpleETL.scala
import org.apache.spark.sql.SparkSession

object SimpleETL {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("SimpleETL")
      .master("local[*]")
      .getOrCreate()

    val df = spark.read.option("header", "true").csv("input.csv")
    df.show()
    spark.stop()
  }
}
