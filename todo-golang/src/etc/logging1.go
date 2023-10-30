package main

import (
	"log"
	"os"
)

var myLogger *log.Logger

func main() {
	// log.SetFlags(0)
	log.Println("Logging")

	myLogger = log.New(os.Stdout, "INFO: ", log.LstdFlags)
	run()
	myLogger.Println("End of Program")

	fpLog, err := os.OpenFile("4.txt", os.O_CREATE|os.O_WRONLY|os.O_APPEND, 0666)
	if err != nil {
		panic(err)
	}
	defer fpLog.Close()

	myLogger = log.New(fpLog, "INFO:: ", log.Ldate|log.Ltime|log.Lshortfile)
	run()
	myLogger.Println("End of Program")
}

func run() {
	myLogger.Println("TEST")
}
