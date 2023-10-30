//IF문(1)

package main

import "fmt"

func main() {
	// 제어문 (조건문)
	// IF문 : 반드시 Boolean 검사 -> 1, 0 (사용불가 : 자동 형 변환 불가)
	// 소괄호 사용 X

	var a int = 20
	b := 20

	// 예제1
	if a >= 15 {
		fmt.Println("15 이상")
	}

	// 예제2
	if b >= 25 {
		fmt.Println("25 이상")
	}

	// 에러발생
	/*
		if b >= 25
		{
			fmt.Println("25 이상")
		}
	*/
	// 에러발생
	/*
		if b >= 25
			fmt.Println("25 이상")
	*/
	// 에러발생
	/*
		if c :=1; c {
			fmt.Println("25 이상")
		}
	*/

	//예제3
	if c := 40; c >= 35 {
		fmt.Println("35 dltkd")
	}
}
