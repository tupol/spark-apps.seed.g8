name         := """$name;format="norm"$"""
organization := "$organization$"
scalaVersion := "2.11.12"

val sparkUtilsVersion = "0.3.1"
val sparkVersion      = "2.3.2"
val sparkXmlVersion   = "0.4.1"
val sparkAvroVersion  = "4.0.0"


// ------------------------------
// DEPENDENCIES AND RESOLVERS

resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"


lazy val providedDependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion force(),
  "org.apache.spark" %% "spark-sql" % sparkVersion force(),
  "org.apache.spark" %% "spark-mllib" % sparkVersion force(),
  "org.apache.spark" %% "spark-streaming" % sparkVersion force(),
  "com.databricks" %% "spark-xml" % sparkXmlVersion,
  "com.databricks" %% "spark-avro" % sparkAvroVersion
)

libraryDependencies ++= providedDependencies.map(_ % "provided")

libraryDependencies ++= Seq(
  "org.tupol" %% "spark-utils" % sparkUtilsVersion,
  "org.tupol" %% "spark-utils" % sparkUtilsVersion % "test" classifier "tests",
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "com.databricks" %% "spark-xml" % sparkXmlVersion % "test",
  "com.databricks" %% "spark-avro" % sparkAvroVersion % "test"
)

// ------------------------------
// TESTING
parallelExecution in Test := false

fork in Test := true

publishArtifact in Test := true

// ------------------------------
// TEST COVERAGE

scoverage.ScoverageKeys.coverageExcludedFiles := ".*BuildInfo.*"

// ------------------------------
// BUILD-INFO
lazy val root = (project in file(".")).
  enablePlugins(BuildInfoPlugin).
  settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "$package$.info"
  )

buildInfoKeys ++= Seq[BuildInfoKey](
  resolvers,
  libraryDependencies in Test,
  BuildInfoKey.map(name) { case (k, v) => "project" + k.capitalize -> v.capitalize },
  BuildInfoKey.action("buildTime") {
    System.currentTimeMillis
  } // re-computed each time at compile
)

buildInfoOptions += BuildInfoOption.BuildTime
buildInfoOptions += BuildInfoOption.ToMap
buildInfoOptions += BuildInfoOption.ToJson

// ------------------------------
