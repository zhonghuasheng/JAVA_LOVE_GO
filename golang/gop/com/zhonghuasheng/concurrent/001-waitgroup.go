package main

import (
	"fmt"
	"sync"
	"time"
)

// 场景一：需要将一件事情拆成不同的 job， 等待全部的 job 执行完才继续执行主程序
func main() {
	var wg sync.WaitGroup
	wg.Add(2)
	go func() {
		time.Sleep(2 * time.Second)
		fmt.Println("job 1 done")
		wg.Done()
	}()

	go func() {
		time.Sleep(2 * time.Second)
		fmt.Println("job 2 done")
		wg.Done()
	}()

	go func() {
		fmt.Println("job 3 done")
		//wg.Done()
	}()

	wg.Wait()
	fmt.Println("all done")
}
