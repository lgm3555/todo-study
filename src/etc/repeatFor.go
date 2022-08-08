package main

import "fmt"

func main() {
	// for 문
	sum := 0
	for i := 1; i <= 100; i++ {
		sum += i
	}
	fmt.Println(sum)

	// 조건문 for 문
	n := 1
	for n < 100 {
		n *= 2
		if n > 90 {
			break
		}
		fmt.Println(n)
	}

	// 무한 루프
	//for {
	//	fmt.Println("Infinite loop")
	//}

	names := []string{"홍길동", "이순신", "강감찬"}
	for index, name := range names {
		fmt.Println(index, name)
	}

	var a = 1
	for a < 15 {
		if a == 5 {
			a += a
			continue
		}
		a++
		if a > 10 {
			break
		}
	}
	if a == 11 {
		goto END
	}
	fmt.Println(a)
END:
	fmt.Println("END")

	z := 0
L1:
	for {
		if z == 0 {
			break L1
		}
	}
	fmt.Println("OK")
}
