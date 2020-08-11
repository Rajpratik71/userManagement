#! /usr/bin/env bash 

./gradlew :core:integrationTest -x :core:classes -x :core:testClasses -x :core:integrationTestClasses
