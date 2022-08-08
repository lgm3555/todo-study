package main

import "fmt"

func main() {
	var a, b int = 5, 3
	var c float64
	var i int = 1

	// 산술 연산자
	c = float64((a + b) / 5)
	i++

	fmt.Println(c, i)

	// 논리 연산자
	// A && B
	// A || !(C && B)

	// Bitwise 연산자
	// c = (a & b) << 5

	// 할당 연산자
	a = 100
	fmt.Println(a)
	a *= 10
	fmt.Println(a)
	a >>= 2
	fmt.Println(a)
	a |= 1
	fmt.Println(a)

	// 포인터 연산자
	var k int = 10
	var p = &k
	fmt.Println(*p)

}
