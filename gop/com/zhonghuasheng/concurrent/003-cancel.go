package main

import (
	"context"
	"fmt"
	"time"
)

func main() {
	ctx, cancel := context.WithCancel(context.Background())

	go worker(ctx, "node1")
	go worker(ctx, "node2")
	go worker(ctx, "node3")

	time.Sleep(5 * time.Second)
	fmt.Println("begin stop the goroutine")
	cancel()
	time.Sleep(5 * time.Second)
}

func worker(ctx context.Context, node string) {
	for {
		select {
		case <-ctx.Done():
			fmt.Println(node, "got the stop sign")
			return
		default:
			fmt.Println(node, "still working")
			time.Sleep(1 * time.Second)
		}
	}
}
