package main

import "fmt"

func main() {
	c := make(chan int)
	go func() {
		defer fmt.Println("sub goroutine end")
		for i := 0; i < 5; i++ {
			c <- i
			fmt.Println("put value into channel ", i)
		}
		close(c) // 如果不执行close 报错 fatal error: all goroutines are asleep - deadlock!
	}()

	for {
		if data, ok := <-c; ok { // 如果channel不关闭，没有数据往channel写了，那么此处不停的读，又读不到，然后阻塞，形成死循环
			fmt.Println("data ", data)
		} else {
			break
		}
	}
}
