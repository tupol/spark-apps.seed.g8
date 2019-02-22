package $package$

import org.scalatest.{FunSuite, Matchers}
import org.tupol.spark.SharedSparkSession
import org.tupol.spark.testing._
import org.tupol.spark.testing.files.{TestTempFilePath1, TestTempFilePath2}
import org.tupol.spark.{SharedSparkSession, io}
import org.tupol.utils.config.ConfigurationException

class $classname$Spec extends FunSuite with Matchers with SharedSparkSession
  with TestTempFilePath1 with TestTempFilePath2 {

  import spark.implicits._
  import $classname$._

  test("transform should ...") {

    transform(spark.emptyDataFrame) shouldBe spark.emptyDataFrame

  }

}
