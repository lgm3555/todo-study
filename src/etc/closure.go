package main

import "fmt"

func main() {
	next := nextValue()

	fmt.Println(next())
	fmt.Println(next())
	fmt.Println(next())

	anotherNext := nextValue()
	fmt.Println(anotherNext())
	fmt.Println(anotherNext())
}

func nextValue() func() int {
	i := 0
	return func() int {
		i++
		return i
	}
}
