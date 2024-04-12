package main

import (
	"fmt"
	"strconv"
)

func printMap(m map[string]int) {
	fmt.Println(m)
}

func main() {
	var mapList map[string]int     // 定义
	mapList = make(map[string]int) // 初始化
	mapList["a"] = 1
	mapList["b"] = 2
	mapList["c"] = 3
	mapList["c"] = 4
	printMap(mapList)
	// 遍历 得到的是key
	for item := range mapList {
		fmt.Println(item)
	}
	for index, value := range mapList {
		fmt.Println("index=", index, ", value=", value)
	}
	// 查看元素是否在集合中存在
	value, exist := mapList["a"]
	if exist {
		fmt.Println(value)
	} else {
		fmt.Println("不存在")
	}
	// 删除
	delete(mapList, "b")
	fmt.Println("删除b后")
	for index, value := range mapList {
		fmt.Println("index=", index, ", value=", value)
	}
	// 初始化capacity
	var mapList2 map[string]int
	mapList2 = make(map[string]int, 3)
	fmt.Println("mapList2 len=", len(mapList2))
	for i := 0; i < 5; i++ {
		mapList2[strconv.Itoa(i)] = i
	}
	fmt.Println(mapList2)
	fmt.Println("mapList2 len=", len(mapList2))
	// 用切片做map值
	mp1 := make(map[int][]int)
	mp1[1] = []int{1, 2, 3, 4}
	fmt.Println(mp1)
}
