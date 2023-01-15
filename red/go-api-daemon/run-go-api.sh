#!/bin/bash
ps axjf | grep "./main" | grep -wv color | tail -n 1 | tr -s '\t' ' ' | cut -d ' ' -f 3 | { read msg; kill -9 "$msg"; } 2> /dev/null
echo " * Restarting Golang JSON REST API"
/root/tools/log4shell-white-box/red/go-api-daemon/./main &