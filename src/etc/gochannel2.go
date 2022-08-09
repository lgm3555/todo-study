package main

import "fmt"

func main() {
	/*
		c := make(chan int)
		c <- 1           //수신루틴이 없으므로 데드락
		fmt.Println(<-c) //코멘트해도 데드락 (별도의 Go루틴없기 때문)
	*/

	ch := make(chan int, 1)
	//수신자가 없더라도 보낼 수 있다.
	ch <- 101
	fmt.Println(<-ch)
}
