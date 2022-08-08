package main

import "fmt"

type person struct {
	name string
	age  int
}

func main() {
	// person 객체 생성
	p := person{}

	// 필드 값 설정
	p.name = "Lee"
	p.age = 10

	fmt.Println(p)

	var p1 person
	p1 = person{"Bob", 20}
	p2 := person{name: "Sean", age: 50}
	fmt.Println(p1)
	fmt.Println(p2)

	p3 := new(person)
	p3.name = "Lee"
	fmt.Println(p3)
}
