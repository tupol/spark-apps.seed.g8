#!/bin/bash


###############################################################################
## Application Configuration Setup                                           ##
###############################################################################

JAR_PATH="../target/scala-2.11"
JAR_NAME=$name;format="norm"$-assembly-$version$.jar


###############################################################################
## Spark Submit Section                                                      ##
###############################################################################

spark-submit  -v  \
--master local[*] \
--deploy-mode client \
--class $package$.$classname$ \
--name $classname$ \
--conf spark.yarn.submit.waitAppCompletion=true \
--queue default \
--files application.conf \
\$JAR_PATH/\$JAR_NAME

