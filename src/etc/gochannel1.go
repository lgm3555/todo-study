package main

import "fmt"

func main() {
	// 정수형 채널을 생성한다
	ch := make(chan int)

	go func() {
		ch <- 123 //채널에 123을 보낸다
	}()

	var i int
	i = <-ch // 채널로부터 123을 받는다
	println(i)

	done := make(chan bool)
	go func() {
		for i := 0; i < 10; i++ {
			fmt.Println(i)
		}
		done <- true
	}()

	// 위의 Go루틴이 끝날 때까지 대기
	<-done
}
