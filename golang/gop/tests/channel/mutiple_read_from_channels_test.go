package channel

import (
	"fmt"
	"testing"
	"time"
)

/**
  从多个channel中读取数据 golang select关键字
*/

func TestReadFromMutipleChannels(t *testing.T) {
	c1 := make(chan string)
	c2 := make(chan string)
	go func() {
		for {
			c1 <- "c1"
			time.Sleep(500 * time.Microsecond)
		}
	}()
	go func() {
		for {
			c2 <- "c2"
			time.Sleep(2000 * time.Microsecond)
		}
	}()
	for {
		select {
		case msg := <-c1:
			fmt.Println(msg)
		case msg := <-c2:
			fmt.Println(msg)
		}
	}
}
