package $package$

import com.typesafe.config.Config
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.catalyst.util.quoteIdentifier
import org.apache.spark.sql.types._
import org.tupol.spark.implicits._
import org.tupol.spark.io._
import org.tupol.spark.{Logging, SparkApp}
import org.tupol.utils.config.Configurator

object $classname$ extends SparkApp[$classname$Context, Unit] {

  override def createContext(config: Config): $classname$Context = $classname$Context(config).get

  override def run(implicit spark: SparkSession, context: $classname$Context): Unit = {
    val inputData = spark.source(context.input).read
    val transformedData = transform(inputData)
    val outputData = if (context.output.format == FormatType.Avro) transformedData.makeAvroCompliant else transformedData
    outputData.sink(context.output).write
  }
  
  def transform(dataframe: DataFrame): DataFrame = {
    //TODO Write the application logic here
    dataframe
  }
  
}

/**
 * Context class for the [[$classname$]]
 *
 * More parameters can be added here depending on the needs.
 * Please check [[https://github.com/tupol/spark-utils-demos]] for more examples.
 *
 * @param input see [[https://github.com/tupol/spark-utils/blob/3.x/docs/data-source.md]]
 * @param output see [[https://github.com/tupol/spark-utils/blob/3.x/docs/data-sink.md]]
 */
case class $classname$Context(input: FormatAwareDataSourceConfiguration,
                              output: FormatAwareDataSinkConfiguration)


object $classname$Context extends Configurator[$classname$Context] {

  import com.typesafe.config.Config
  import scalaz.ValidationNel

  def validationNel(config: Config): ValidationNel[Throwable, $classname$Context] = {
    import org.tupol.utils.config._
    import scalaz.syntax.applicative._
    config.extract[FormatAwareDataSourceConfiguration]("input") |@|
      config.extract[FormatAwareDataSinkConfiguration]("output") apply
      $classname$Context.apply
  }
}
