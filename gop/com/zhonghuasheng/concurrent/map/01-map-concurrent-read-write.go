package main

import "sync"

func main() {
	// 并发读
	//testConcurrentRead()

	// 并发写
	testConcurrentWrite()
	// fatal error: concurrent map writes

	// 测试验证并发读写不同的key
	//testConcurrentReadWriteDiffKey()
	// 如期报错：fatal error: concurrent map read and map write

	//testConcurrentReadWriteSameKey()
	// 报错：fatal error: concurrent map read and map write

	// 读不加锁，写加锁
	//testConcurrentReadLockWrite()
	// 报错：fatal error: concurrent map read and map write

	// 读加锁，写加锁
	//testConcurrentLockReadLockWrite()

	/**
	  结论： 只要有更新的操作，map就是非线程安全
	*/
}

// 读加锁，写加锁
func testConcurrentLockReadLockWrite() {
	var demo = struct {
		M map[int]int
		L sync.RWMutex
	}{
		M: make(map[int]int),
	}

	go func() {
		for {
			demo.L.RLock()
			_ = demo.M[10]
			demo.L.RUnlock()
		}
	}()
	go func() {
		for {
			demo.L.Lock()
			demo.M[100] = 100
			demo.L.Unlock()
		}
	}()
	select {}
}

// 读不加锁，写加锁
func testConcurrentReadLockWrite() {
	var demo = struct {
		M map[int]int
		L sync.RWMutex
	}{
		M: make(map[int]int),
	}

	go func() {
		for {
			_ = demo.M[10]
		}
	}()
	go func() {
		for {
			demo.L.Lock()
			demo.M[100] = 100
			demo.L.Unlock()
		}
	}()
	select {}
}

// 测试并发读写相同key
func testConcurrentReadWriteSameKey() {
	m := make(map[int]int)
	go func() {
		for {
			m[100] = 100
		}
	}()
	go func() {
		for {
			_ = m[100]
		}
	}()
	// 阻塞不退出
	select {}
}

// 测试验证并发读写不同的key
func testConcurrentReadWriteDiffKey() {
	m := make(map[int]int)
	go func() {
		for {
			m[100] = 100
		}
	}()
	go func() {
		for {
			_ = m[1]
		}
	}()
	// 阻塞不退出
	select {}
}

func testConcurrentWrite() {
	m := make(map[int]int)
	go func() {
		for {
			m[10] = 10
		}
	}()
	go func() {
		for {
			m[10] = 101
		}
	}()
	select {}
}

func testConcurrentRead() {
	m := make(map[int]int)
	go func() {
		for {
			_ = m[10]
		}
	}()
	go func() {
		for {
			_ = m[101]
		}
	}()
	select {}
}
