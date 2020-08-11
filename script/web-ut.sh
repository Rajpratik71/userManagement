#! /usr/bin/env bash 

./gradlew :web:test -x :core:jar -x :web:classes -x :web:testClasses
