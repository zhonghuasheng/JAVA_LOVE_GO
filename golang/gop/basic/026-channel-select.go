package main

import "fmt"

func main() {
	c := make(chan int)
	d := make(chan int)
	quit := make(chan int)
	go func() {
		for i := 0; i < 6; i++ {
			// 从c中读取
			fmt.Println("c", <-c)
			fmt.Println("d", <-d)
		}
		quit <- 0
		fmt.Println("sub end")
	}()
	fblc(c, d, quit)
}

func fblc(c chan int, d chan int, quit chan int) {
	x, y := 1, 1
	for {
		select {
		case c <- x: // 如果c可写，将x写入，执行 x,y逻辑，那么要执行多少次呢，由于设置的是无缓存的，所以读多少次就写多少次
			x = y
			y = x + y
		case d <- x:
			fmt.Println("ddddddd")
		case <-quit: // 如果quit可读，执行下面逻辑
			fmt.Println("quit")
			return
		}

	}
}
