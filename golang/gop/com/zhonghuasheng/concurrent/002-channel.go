package main

import (
	"fmt"
	"time"
)

// 场景二：需要主动通知并停止正在跑的job
func main() {
	stop := make(chan bool)

	go func() {
		for {
			select {
			case <-stop:
				fmt.Println("get stop sign")
				return // 通过return来终止程序
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
