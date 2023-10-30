package main

import "fmt"

func main() {

	add := func(i int, j int) int {
		return i + j
	}

	r1 := calc(add, 3, 3)
	fmt.Println(r1)
}

type calculator func(int, int) int

func calc(f calculator, a int, b int) int {
	result := f(a, b)
	return result
}
