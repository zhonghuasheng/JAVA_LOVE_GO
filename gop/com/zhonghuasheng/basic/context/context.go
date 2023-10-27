package main

import (
	"context"
	"fmt"
)

func main() {
	ctx := context.Background()
	deadline, ok := ctx.Deadline()
	if ok {
		fmt.Printf("background ctx, deadline: %v", deadline)
	} else {
		fmt.Printf("background ctx, no deadline: %v", deadline)
	}
}
