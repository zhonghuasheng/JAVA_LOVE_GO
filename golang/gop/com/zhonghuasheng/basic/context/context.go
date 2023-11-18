package main

import (
	"context"
	"fmt"
	"time"
)

func main() {
	// 输出 context.Background的 Deadline，结果是 background ctx, no deadline: 0001-01-01 00:00:00 +0000 UTC
	ctx := context.Background()
	deadline, ok := ctx.Deadline()
	if ok {
		fmt.Printf("background ctx, deadline: %v\n", deadline)
	} else {
		fmt.Printf("background ctx, no deadline: %v\n", deadline)
	}
	//
	ctx2, cancel2 := context.WithTimeout(context.Background(), 1*time.Minute)
	time.Sleep(2 * time.Second)
	deadline2, ok2 := ctx2.Deadline()
	if ok2 {
		// 输出 backgroupd ctx with timeout 60s, current deadline:57.9917492s
		fmt.Printf("backgroupd ctx with timeout 60s, current deadline:%v\n", time.Until(deadline2).String())
		cancel2()
	}

}
