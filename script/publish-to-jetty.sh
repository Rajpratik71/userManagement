#! /usr/bin/env bash 

cp web.war "$1/webapps"

echo 'Restarting jetty ...'
"$1/bin/jetty.sh" restart > /dev/null 2>&1
