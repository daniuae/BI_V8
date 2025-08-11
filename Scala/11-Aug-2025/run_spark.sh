#!/bin/zsh/
export JAVA_HOME=$(/usr/libexec/java_home -v 17)
export PATH=$JAVA_HOME/bin:$PATH
$SPARK_HOME/bin/spark-shell
