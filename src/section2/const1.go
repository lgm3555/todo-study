package main

import "fmt"

func main() {
	//상수
	//const 사용 초기화, 한 번 선언 후 값 변경 금지, 고정 된 값 관리용
	const a string = "TEST1"
	const b = "TEST2"
	const c int32 = 10 * 10
	//const d = getHeight()
	const e = 35.6
	const f = false
	/*
		에러 발생 경우
		const g string
		g = "TEST3"
	*/

	fmt.Println("a : ", a, "b : ", b, "c : ", c, "e : ", e, "f : ", f)
}
