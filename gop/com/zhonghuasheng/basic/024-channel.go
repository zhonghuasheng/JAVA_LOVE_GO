package main

import "fmt"

func main() {

	c := make(chan int)
	go func() {
		defer fmt.Println("sub def")
		c <- 666 // 发送有可能阻塞
		fmt.Println("sub end")
	}()
	num := <-c // 接受也有可能阻塞。对比下023，那里使用了time.Sleep来阻塞主线程，这里没有使用，但是使用了管道接受数据，同样达到了阻塞的效果
	fmt.Println(num)
}
