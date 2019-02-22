# $name$

## Description

$description$


## Next steps

Out of the box you have created a simple Spark project skeleton.

Add your logic in the
[`$package$.$classname$.transform()`](src/main/scala/$package;format = "packaged"$/$classname$.scala) function.

After implementing the logic, one should take care of some basic unit tests at least.
Add your tests in the
[`$package$.$classname$Spec`](src/test/scala/$package;format = "packaged"$/$classname$Spec.scala) test class.
The test class provides a test stub, but one should embrace testing and adding more unit tests, as they see fit.

Finally, a [sample shell script](sample-script/$scriptname$.sh) together with an
[application configuration](sample-script/application.conf) file are provided.
This can be quickly tested.
First, we need to assemble the application. Inside the project folder run
```
sbt assembly
```
If everything goes well, we should have the assembly jar in the [`target/scala-2.11/`](target/scala-2.11/) folder.

Now we can try running the script.
```
cd sample-script
./$scriptname$.sh
```
The script is not runnable out of the bat as it lacks input and output source configuration.

For more details about configuration and sample scripts please check the
[spark-utils-demos](https://github.com/tupol/spark-utils-demos) project.


## References

- [spark-utils](https://github.com/tupol/spark-utils)
- [spark-utils-demos](https://github.com/tupol/spark-utils-demos)
- [spark-utils-demos.wiki](https://github.com/tupol/spark-utils-demos/wiki)
