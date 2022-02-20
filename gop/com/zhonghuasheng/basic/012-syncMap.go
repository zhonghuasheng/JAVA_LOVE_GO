package main

import (
	"fmt"
	"sync"
)

func main() {
	// 并发环境下是sync.Map
	var scene sync.Map
	scene.Store("greece", 97)
	scene.Store("london", 100)
	scene.Store("egypt", 200)
	fmt.Println(scene.Load("london"))
	// 从sync.Map中获取键值
	load, ok := scene.Load("london")
	if ok {
		fmt.Println(load)
	}
	// 根据键删除对应的key
	scene.Delete("london")
	// 遍历所有sync.Map中的键值对
	scene.Range(func(key, value interface{}) bool {
		fmt.Println("iterator: ", key, value)
		return true
	})
}
