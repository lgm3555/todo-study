package main

import (
	"fmt"
	"log"
	"net"
	"net/http"
	"os"
)

func gohandler(w http.ResponseWriter, r *http.Request) {
	name, err := os.Hostname()
	if err != nil {
		fmt.Printf("error: %v\n", err)
		return
	}
	fmt.Fprintln(w, "Hostname: ", name)

	addr, err := net.LookupHost(name)
	if err != nil {
		fmt.Printf("error : %v\n", err)
	}
	fmt.Fprintln(w, "IP: ", addr)
}

func main() {
	fmt.Fprintln(os.Stdout, "Go!!! Go Application ....")
	http.HandleFunc("/", gohandler)
	log.Fatal(http.ListenAndServe(":9090", nil))
}
