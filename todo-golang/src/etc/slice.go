package main

import "fmt"

func main() {
	var a []int
	a = []int{1, 2, 3}
	a[1] = 10
	fmt.Println(a)

	// 내장함수 make
	b := make([]int, 5, 10)
	fmt.Println(b)
	fmt.Println(len(b), cap(b))

	// 부분 슬라이스
	sub := []int{0, 1, 2, 3, 4, 5}
	sub = sub[2:5]
	fmt.Println(sub)

	// 슬라이스 추가, 병합, 복사
	c := []int{0, 1}
	// 하나 확장
	c = append(c, 2)
	// 복수 요소들 확장
	c = append(c, 3, 4, 5)
	fmt.Println(c)

	// len=0, cap=3 슬라이스
	sliceA := make([]int, 0, 3)
	// 계속 한 요소씩 추가
	for i := 1; i <= 15; i++ {
		sliceA = append(sliceA, i)
		// len, cap 확인
		fmt.Println(len(sliceA), cap(sliceA))
	}
	fmt.Println(sliceA)

	//다른 slice에 붙이기
	sliceB := []int{1, 2, 3}
	sliceC := []int{4, 5, 6}
	sliceB = append(sliceB, sliceC...)
	fmt.Println(sliceB)

	// 내장함수 copy
	source := []int{0, 1, 2}
	target := make([]int, len(source), cap(source)*2)
	copy(target, source)
	fmt.Println(target)
	fmt.Println(len(target), cap(target))
}
