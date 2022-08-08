package main

import "fmt"

func main() {
	var m map[int]string

	m = make(map[int]string)
	// 추가 혹은 갱신
	m[901] = "Apple"
	m[134] = "Grape"
	m[777] = "Tomato"

	// 키에 대한 값 읽기
	str := m[134]
	fmt.Println(str)

	// 값이 없으면 nil 혹은 zero 리턴
	noData := m[999]
	fmt.Println(noData)

	// 삭제
	delete(m, 777)

	fmt.Println(m)

	fmt.Println("------")

	tickers := map[string]string{
		"GOOG": "Google Inc",
		"MSFT": "Microsoft",
		"FB":   "FaceBook",
		"AMZN": "Amazon",
	}

	val, exists := tickers["MSFT"]
	fmt.Println(val, exists)
	if !exists {
		fmt.Println("No MSFT ticker")
	}

	fmt.Println("------")

	myMap := map[string]string{
		"A": "Apple",
		"B": "Banana",
		"C": "Charlie",
	}

	// for range 문을 사용하여 모든 맵 요소 출력
	// Map은 unordered 이므로 순서는 무작위
	for key, val := range myMap {
		fmt.Println(key, val)
	}
}
