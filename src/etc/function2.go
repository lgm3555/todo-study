package main

import "fmt"

func main() {
	//익명함수 정의
	sum := func(n ...int) int {
		s := 0
		for _, i := range n {
			s += i
		}
		return s
	}

	result := sum(1, 2, 3, 4, 5)
	fmt.Println(result)
}
