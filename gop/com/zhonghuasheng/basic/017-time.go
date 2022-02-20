package main

import (
	"fmt"
	"time"
)

func main() {
	start := time.Now()
	sum := 0
	for i := 0; i < 1000000; i++ {
		sum++
	}
	duration := time.Since(start)
	fmt.Println("duration = ", duration)
	sub := time.Now().Sub(start)
	fmt.Println("duration sub=", sub)
}
