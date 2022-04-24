package main

import (
	"fmt"
	"time"
)

func main() {
	stop := make(chan bool)

	go func() {
		for {
			select {
			case <-stop:
				fmt.Println("get stop sign")
				return
			default:
				fmt.Println("go go go 向前走")
				time.Sleep(1 * time.Second)
			}
		}
	}()

	time.Sleep(5 * time.Second)
	fmt.Println("stop the gorutine")
	stop <- true
	time.Sleep(5 * time.Second) // 等待chan获得stop信号后任务执行完
}
