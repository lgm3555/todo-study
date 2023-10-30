package main

import "fmt"

func main() {
	// 변수 add에 익명함수 할당
	add := func(i int, j int) int {
		return i + j
	}

	// add 함수 전달
	r1 := calc(add, 10, 20)
	fmt.Println(r1)

	// 직접 첫번째 파라미터에 익명함수를 정의
	r2 := calc(func(x int, y int) int { return x - y }, 10, 20)
	fmt.Println(r2)
}

func calc(f func(int, int) int, a int, b int) int {
	result := f(a, b)
	return result
}
