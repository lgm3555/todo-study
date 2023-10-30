package main

import "fmt"

//Rect - struct 정의
type Rect struct {
	width, height int
}

//Rect의 area() 메소드
func (r Rect) area1() int {
	return r.width * r.height
}

func (r *Rect) area2() int {
	r.width++
	return r.width * r.height
}

func main() {
	rect1 := Rect{10, 20}
	area1 := rect1.area1()
	fmt.Println(area1)

	rect2 := Rect{10, 20}
	area2 := rect2.area2()
	fmt.Println(area2)
}
