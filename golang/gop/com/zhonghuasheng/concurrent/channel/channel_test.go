package channel

import (
	"fmt"
	"sync"
	"testing"
	"time"
)

type User struct {
	attrs map[string]string
}

func TestWriteMap(t *testing.T) {
	u := &User{attrs: make(map[string]string)}
	for i := 0; i < 10; i++ {
		go func(user *User) {
			user.attrs[fmt.Sprintf("%v", i)] = fmt.Sprintf("%v", i)
		}(u)
	}
	time.Sleep(time.Second * 2)
	fmt.Println(u)
}

type User2 struct {
	attrs sync.Map
}

func TestWriteMap2(t *testing.T) {
	u := &User2{}
	var wg sync.WaitGroup
	n := 10
	wg.Add(10)
	for i := 0; i < n; i++ {
		go func(user *User2, i int) {
			defer wg.Done()
			user.attrs.Store(fmt.Sprintf("%v", i), fmt.Sprintf("%v", i))
		}(u, i)
	}
	wg.Wait()
	fmt.Println(u.attrs)
}
