#! /usr/bin/env bash 

gradlew.bat :web:test -x :core:jar -x :web:classes -x :web:testClasses
