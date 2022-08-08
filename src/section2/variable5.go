package main

import "fmt"

func main() {
	var i int = 100
	var u uint = uint(i)
	var f float32 = float32(i)

	fmt.Println(f, u)

	str := "ABC"
	bytes := []byte(str)
	str2 := string(bytes)

	fmt.Println(bytes, str2)
}
