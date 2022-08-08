package main

import (
	"fmt"
	"log"
	"os"
)

type error interface {
	Error() string
}

func main() {
	f, err := os.Open("C:\\temp\\1.txt")
	if err != nil {
		log.Fatal(err.Error())
	}
	fmt.Println(f.Name())
}
