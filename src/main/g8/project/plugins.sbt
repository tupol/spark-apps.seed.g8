logLevel := Level.Warn

resolvers += "Sonatype OSS Staging" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"

resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"

resolvers += "Typesafe repo" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.0")

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.1")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.5.0")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

addSbtPlugin("com.typesafe.sbt" %% "sbt-native-packager" % "1.3.6")
