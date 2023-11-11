package main

import "fmt"

func main() {
	for i := 0; i < 10000; i++ {
		go goFun(i) // 使用go关键字开启协程，提高并发
	}
}

func goFun(i int) {
	fmt.Println("goroutine ", i, "...")
}
