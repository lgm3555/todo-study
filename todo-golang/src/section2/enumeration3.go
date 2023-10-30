package main

import "fmt"

func main() {
	const (
		_ = iota
		A
		B
		C
	)

	const (
		_ = iota + 0.75*2
		DEFAULT
		SILVER
		_
		PLATINUM
	)

	fmt.Println("DEFAULT : ", DEFAULT)
	fmt.Println("SILVER : ", SILVER)
	fmt.Println("PLATINUM : ", PLATINUM)
}
