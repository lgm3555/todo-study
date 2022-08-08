package main

import "fmt"

func main() {
	msg := "Hello"

	say1(msg)

	fmt.Println("&msg = ", &msg)
	say2(&msg)
	fmt.Println(msg)

	say3("This", "is", "a", "book")
	say3("Hi")

	total := sum1(1, 7, 3, 5, 9)
	fmt.Println(total)

	count, total := sum2(1, 7, 3, 5, 9)
	fmt.Println(count, total)

}

// 함수
// Pass By Value
func say1(msg string) {
	println(msg)
}

// Pass By Reference
func say2(msg *string) {
	fmt.Println(*msg)
	*msg = "Changed" // 메시지 변경
}

// 가변 인자 함수
func say3(msg ...string) {
	for _, s := range msg {
		fmt.Println(s)
	}
}

// 함수 리턴값
func sum1(nums ...int) int {
	s := 0
	for _, n := range nums {
		s += n
	}
	return s
}

// 함수 리턴값
func sum2(nums ...int) (int, int) {
	s := 0
	count := 0
	for _, n := range nums {
		s += n
		count++
	}
	return count, s
}

func sum3(nums ...int) (count int, total int) {
	for _, n := range nums {
		total += n
	}
	count = len(nums)
	return
}
