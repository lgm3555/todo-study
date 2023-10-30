package main

import "fmt"

func main() {
	ch1 := make(chan string, 1)
	sendChan(ch1)
	receiveChan(ch1)

	ch2 := make(chan int, 2)

	// 채널에 송신
	ch2 <- 1
	ch2 <- 2

	// 채널을 닫는다
	close(ch2)

	// 채널 수신
	println(<-ch2)
	println(<-ch2)

	/*
		for {
			if i, success := <-ch2; success {
				println(i)
			} else {
				break
			}
		}
	*/

	for i := range ch2 {
		println(i)
	}
}

func sendChan(ch chan<- string) {
	ch <- "Data"
}

func receiveChan(ch <-chan string) {
	data := <-ch
	fmt.Println(data)
}
