#! /usr/bin/env bash 

gradlew.bat :web:war -x :core:jar -x :web:classes
