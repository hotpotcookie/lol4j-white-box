#!/bin/bash
#----------
opt_changes() {
	[[ -f revshell.properties.bak ]] && rm revshell.properties.bak || touch revshell.properties.bak	
	[[ ! -z "$1" ]] && echo "HOST=$1" >> revshell.properties.bak || sed -n 1p revshell.properties >> revshell.properties.bak
	[[ ! -z "$2" ]] && echo "PORT_LISTENER=$2" >> revshell.properties.bak || sed -n 2p revshell.properties >> revshell.properties.bak
	[[ ! -z "$3" ]] && echo "PORT_JAVA_HTTP=$3" >> revshell.properties.bak || sed -n 3p revshell.properties >> revshell.properties.bak	
	[[ ! -z "$4" ]] && echo "SHELL=$4" >> revshell.properties.bak || sed -n 4p revshell.properties >> revshell.properties.bak	
	sleep 1
	cp revshell.properties.bak revshell.properties
	rm revshell.properties.bak
	cat revshell.properties
}
#----------
while getopts ":h:l:j:s:" opt; do
	case $opt in
		h) h="${OPTARG}" ;;
		l) l="${OPTARG}" ;;
		j) j="${OPTARG}" ;;
		s) s="${OPTARG}" ;;
	esac
done
#----------
opt_changes "$h" "$l" "$j" "$s"