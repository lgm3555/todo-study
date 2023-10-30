package main

import "fmt"

func main() {
	var k int = 1

	// if 문
	if k == 1 {
		fmt.Println("One")
	} else if k == 2 {
		fmt.Println("Two")
	} else {
		fmt.Println("Other")
	}

	var i, max int = 1, 3

	if val := i * 2; val < max {
		fmt.Println(val)
	}
}
