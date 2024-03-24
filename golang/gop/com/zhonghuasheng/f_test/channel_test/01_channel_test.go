package channeltest_test

import (
	"fmt"
	"testing"
)

func TestChannelBasicStructure(t *testing.T) {
	ch := make(chan int, 8)
	fmt.Println(len(ch))
	for i := 1; i < len(ch); i++ {
		ch <- i
	}
	v := <-ch
	fmt.Println(v)
	// var ch chan int        // 管道的声明
	// ch = make(chan int, 8) // 管道的初始化，环形队列里可容纳8个int
	// ch <- 1                // 往管道里写入(send)数据
	// ch <- 2
	// ch <- 3
	// ch <- 4
	// ch <- 5
	// v := <-ch      // 从管道里取走(recv)数据
	// fmt.Println(v) // 打印1
	// v = <-ch
	// fmt.Println(v) // 打印2
	// v = <-ch
	// fmt.Println(v) // 打印3

}
