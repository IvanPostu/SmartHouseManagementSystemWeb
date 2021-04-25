#!/bin/bash


attachDebugger=$1

attachDebuggerFlag='-a'

if [ "$attachDebugger" = "$attachDebuggerFlag" ]
then 

  ./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -Dspring.profiles.active=dev"
  
else
    
  echo "If you want to debug remotely add flag $attachDebuggerFlag"

  ./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=dev"

fi

