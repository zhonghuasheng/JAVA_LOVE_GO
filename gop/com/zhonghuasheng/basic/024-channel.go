package main

import (
	"fmt"
	"time"
)

func main() {

	// 无缓冲的channel
	c := make(chan int)
	go func() {
		defer fmt.Println("sub def")
		c <- 666 // 发送有可能阻塞
		fmt.Println("sub end")
	}()
	num := <-c // 接受也有可能阻塞。对比下023，那里使用了time.Sleep来阻塞主线程，这里没有使用，但是使用了管道接受数据，同样达到了阻塞的效果
	fmt.Println(num)

	// 有缓冲的channel
	ch := make(chan int, 3)
	fmt.Println("ch len(ch)=", len(ch), ", capacity cap(ch) =", cap(ch))
	go func() {
		defer fmt.Println("next sub defer")
		for i := 0; i < 5; i++ { // 缓冲为3，go程把channel塞满之后，就处于阻塞了，必须等有空的才能继续
			ch <- i
			fmt.Println("i=", i, " len=", len(ch), "  cap=", cap(ch))
		}
	}()

	time.Sleep(2 * time.Second)
	for i := 0; i < 5; i++ {
		out := <-ch
		fmt.Println(out)
	}
}
