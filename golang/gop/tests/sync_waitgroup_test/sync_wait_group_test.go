package sync_waitgroup_test

import (
	"fmt"
	"sync"
	"testing"
)

func Test01(t *testing.T) {
	wg := sync.WaitGroup{}
	wg.Add(1)
	for i := 0; i < 3; i++ {
		wg.Add(1)
		go func(index int) {
			defer func(z int) {
				fmt.Println(z, "defer")
			}(index)
			fmt.Println(index, "logic")
			wg.Done()
		}(i)
	}
	wg.Done()
	wg.Wait()
	fmt.Println("done")
}

/*
https://studygolang.com/articles/12972
=== RUN   Test01
2 logic - 先输出逻辑
2 defer - 再执行每个协程defer函数
0 logic
0 defer
1 logic
1 defer
done  -  主程序执行完毕后执行
--- PASS: Test01 (0.00s)
PASS
*/
