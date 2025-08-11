#!/bin/zsh
#For Spark (Java 8)
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
export PATH=$JAVA_HOME/bin:$PATH
$HIVE_HOME/bin/hive

