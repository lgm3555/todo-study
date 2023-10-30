// For문 (2)
package main

import "fmt"

func main() {
	//예제1
	sum1 := 0
	for i := 0; i <= 100; i++ {
		sum1 += 1
	}
	fmt.Println("ex1 : ", sum1)

	//예제2
	sum2, i := 0, 0

	for i <= 100 {
		sum2 += i
		i++
		// j := i++ // 후치 연산은 반환 값 X
	}
	fmt.Println("ex2 : ", sum2)

	//예제3
	sum3, i := 0, 0

	for {
		if i > 100 {
			break
		}
		sum3 += i
		i++
	}
	fmt.Println("ex3 : ", sum3)

	//예제4
	for i, j := 0, 0; i <= 10; i, j = i+1, j+10 {
		fmt.Println("ex4 : ", i, j)
	}

	/*
		//에러발생
		for i, j := 0, 0; i <= 10; i++, j += 10 {
			//fmt.Println("ex4 : ", i, j)
		}
	*/
}
