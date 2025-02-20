package main
//----------
import (
    json     "encoding/json"
    ioutil   "io/ioutil"
    log      "log"
    http     "net/http"
    mux      "github.com/gorilla/mux"
    fmt      "fmt"
    net      "net"
)

//----------
type property struct {
    HOST            string `json:"HOST"`
    SHELL           string `json:"SHELL"`    
    PORT_LISTENER   string `json:"PORT_LISTENER"`
    PORT_JAVA_HTTP  string `json:"PORT_JAVA_HTTP"`
}
type allProperties []property;
var properties = allProperties{
    {
        HOST:"192.168.113.9",
        SHELL: "/bin/bash",
        PORT_LISTENER: "60606",
        PORT_JAVA_HTTP: "49152",
    },
}

//----------
type ENCODING struct {
    EXTENSION   string `json:"EXTENSION"`
    BASE32      string `json:"BASE32"`
} 
type capture struct {
    TYPE            string `json:"TYPE"`
    TITLE           string `json:"TITLE"`
    TIMESTAMP       string `json:"TIMESTAMP"`
    ENCODING        ENCODING `json:"ENCODING"`
}
type allCaptures []capture;
var captures = allCaptures{};

//----------
func rootPath(w http.ResponseWriter, r *http.Request) {
    fmt.Fprintf(w, "[{\"properties\": \"http://%s:2080/properties\",\"captures\": \"http://%s:2080/captures\"}]",externalIP(),externalIP());
}

//----------
func getProperties(w http.ResponseWriter, r *http.Request) {
    json.NewEncoder(w).Encode(properties);
}
func getCaptures(w http.ResponseWriter, r *http.Request) {
    json.NewEncoder(w).Encode(captures);
}

//----------
func updateProperties(w http.ResponseWriter, r *http.Request) {
    var updatedProperty property;
    reqBody,_ := ioutil.ReadAll(r.Body);
    json.Unmarshal(reqBody, &updatedProperty);
    //----------
    for i, key := range properties {
        if len(updatedProperty.HOST) > 0 { key.HOST = updatedProperty.HOST; } else { key.HOST = key.HOST; }
        if len(updatedProperty.SHELL) > 0 { key.SHELL = updatedProperty.SHELL; } else { key.SHELL = key.SHELL; }
        if len(updatedProperty.PORT_LISTENER) > 0 { key.PORT_LISTENER = updatedProperty.PORT_LISTENER; } else { key.PORT_LISTENER = key.PORT_LISTENER; }
        if len(updatedProperty.PORT_JAVA_HTTP) > 0 { key.PORT_JAVA_HTTP = updatedProperty.PORT_JAVA_HTTP; } else { key.PORT_JAVA_HTTP = key.PORT_JAVA_HTTP; }
        properties = append(properties[:i], key);
        json.NewEncoder(w).Encode(key);
    }
}
func addCaptures(w http.ResponseWriter, r *http.Request) {
    var newCapture capture;
    reqBody,_ := ioutil.ReadAll(r.Body);
    json.Unmarshal(reqBody, &newCapture);
    captures = append(captures, newCapture);  
    w.WriteHeader(http.StatusCreated);
    json.NewEncoder(w).Encode(newCapture);
}

//----------
func main() {
    router := mux.NewRouter().StrictSlash(true);
    router.HandleFunc("/", rootPath).Methods("GET");    
    router.HandleFunc("/properties", getProperties).Methods("GET");
    router.HandleFunc("/properties", updateProperties).Methods("PATCH");
    router.HandleFunc("/captures", getCaptures).Methods("GET");
    router.HandleFunc("/captures", addCaptures).Methods("POST");    
    log.Fatal(http.ListenAndServe(":2080", router));
}

//----------
//----------
func externalIP() (string) {
    ifaces,_ := net.Interfaces()
    for _, iface := range ifaces {
        addrs,_ := iface.Addrs()
        for _, addr := range addrs {
            var ip net.IP
            switch v := addr.(type) {
            case *net.IPNet:
                ip = v.IP
            case *net.IPAddr:
                ip = v.IP
            }
            if ip == nil || ip.IsLoopback() {
                continue
            }
            ip = ip.To4()
            if ip == nil {
                continue // not an ipv4 address
            }
            return ip.String()
        }
    }
    return ""
}