#! /usr/bin/env bash 

cp web.war "$1/webapps"
"$1/bin/jetty.sh" restart
