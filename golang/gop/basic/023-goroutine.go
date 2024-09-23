package main

import (
	"fmt"
	"time"
)

func main() {
	defer fmt.Println("main defer")
	func() {
		fmt.Println("test")
	}()
	go func() {
		defer fmt.Println("sub defer")
		//runtime.Goexit()
		fmt.Println("sub end")
	}()

	time.Sleep(1 * time.Second)
	fmt.Println("main process")
	/**
	  main process
	  main defer
	  为什么sub没执行？ 不是没执行，是main线程执行的太快了
	*/
}
