package main

import "fmt"

func main() {
	var a [3]int
	a[0] = 1
	a[1] = 2
	a[2] = 3
	fmt.Println(a[1])

	var b = [3]int{1, 2, 3}
	fmt.Println(b)

	var c = [...]int{1, 2, 3, 4}
	fmt.Println(c)

	var multiArray1 [3][4][5]int
	multiArray1[0][1][2] = 10
	fmt.Println(multiArray1)

	var multiArray2 = [2][3]int{
		{1, 2, 3},
		{4, 5, 6},
	}
	fmt.Println(multiArray2)
}
