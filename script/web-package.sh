#! /usr/bin/env bash 

./gradlew :web:war -x :core:jar -x :web:classes
