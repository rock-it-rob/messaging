#!/bin/sh

scheme=http
host=localhost
port=8080
context=rs
uri=health

url=${scheme}://${host}:${port}/${context}/${uri}

status=`curl ${url} --stderr /dev/null -o /dev/null -w %{http_code}`

if [ $status -ne 200 ]; then
  exit 1
fi
