# **[spark-utils][sut]** Based Project Template

This is a [Giter8][g8] template for `spark-utils` based projects.

It helps setting up a Spark application project quickly.

## Basic usage

To fill in manually the project options run
```
g8 tupol/spark-apps.seed.g8
```

The default options look like the following:
```
name [My Project]:
appname [My First App]:
organization [my.org]:
version [0.0.1-SNAPSHOT]:
package [my.org.my_project]:
classname [MyFirstApp]:
scriptname [my-first-app]:
scalaVersion [2.11.12]:
sparkVersion [2.4.0]:
sparkUtilsVersion [0.4.0]:
```

To fill in the options in advance
```
g8 tupol/spark-apps.seed.g8 --name="My Project" --appname="My App" --organization="my.org" --force
```


## References

- [Giter8][g8]
- [`sbt` new and Templates][sbtt]
- [`spark-utils`][sut]

[g8]: http://www.foundweekends.org/giter8/
[sbtt]: https://www.scala-sbt.org/1.0/docs/sbt-new-and-Templates.html
[sut]: https://github.com/tupol/spark-utils
