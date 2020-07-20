package main

import (
	"fmt"
)

func main() {
	mychanl1 := make(<-chan string)

	// Only for sending
	mychanl2 := make(chan<- string)

	// Display the types of channels
	fmt.Printf("%T", mychanl1)
	fmt.Printf("\n%T\n", mychanl2)
}

func provider(ch chan int, done chan bool) {
	for i := 0; i < 10; i++ {
		ch <- i
	}
	close(ch)

	done <- true
}

func sum(i int, res chan int) {
	sum := 0
	for i != 0 {
		digit := i % 10
		sum += digit * digit
		i /= 10
	}
	res <- sum
}

func mul(i int, res chan int) {
	m := 1
	for i > 0 {
		m *= i
		i--
	}
	res <- m
}

func call(b chan bool) {
	fmt.Println("Before loop finish..")
	<-b
}

func loop1(b chan bool) {
	fmt.Println("Loop 1 called")
	<-b
}

func loop2(b chan bool) {
	fmt.Println("Loop 2 called")
	b <- true
}
