// ===============================================================
//  SIMPLE ETL PIPELINE USING SPARK + SCALA
// ===============================================================

import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.sql.functions._

object SimpleETLPipeline {

  def main(args: Array[String]): Unit = {

    // ---------------------------------------------------------------
    // 1. EXTRACT
    // ---------------------------------------------------------------
    // Create Spark session
    val spark = SparkSession.builder()
      .appName("Simple ETL Example")
      .master("local[*]")     // Run locally
      .getOrCreate()

    // Read input CSV file
    val inputPath = "customers.csv"

    val rawDF = spark.read
      .option("header", "true")   // First row contains column names
      .option("inferSchema", "true")
      .csv(inputPath)

    println("===== RAW DATA =====")
    rawDF.show()

    // ---------------------------------------------------------------
    // 2. TRANSFORM
    // ---------------------------------------------------------------
    // Example transformations:
    // - Trim spaces
    // - Convert name to proper case
    // - Filter customers older than 18
    // - Add a new column: full_name
    // - Rename columns

    val cleanedDF = rawDF
      .withColumn("first_name", initcap(trim(col("first_name"))))
      .withColumn("last_name", initcap(trim(col("last_name"))))
      .withColumn("full_name", concat_ws(" ", col("first_name"), col("last_name")))
      .filter(col("age") > 18)
      .withColumnRenamed("location", "city")

    println("===== CLEANED DATA =====")
    cleanedDF.show()

    // ---------------------------------------------------------------
    // 3. LOAD
    // ---------------------------------------------------------------
    // Write output as Parquet (compressed, optimized)
    val outputPath = "clean_customers"

    cleanedDF.write
      .mode("overwrite")      // overwrite output folder
      .parquet(outputPath)

    println(s"Data successfully written to $outputPath")

    // Stop Spark session
    spark.stop()
  }
}
