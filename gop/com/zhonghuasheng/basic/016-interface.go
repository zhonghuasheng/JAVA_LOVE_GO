package main

import (
	"fmt"
)

// 定义一个接口
type People interface {
	ReturnName() string
}

// 定义一个结构体
type Student struct {
	Name string
}

// 定义结构体的一个方法
// 这个方法实现了People接口的所有方法，故任务结构体Student实现了People接口
func (s Student) ReturnName() string {
	return s.Name
}

func main() {
	cbs := Student{Name: "Luke Chen"}
	var a People
	// Student实现了接口People，所以可以直接赋值
	// 如果没有实现呢？
	a = cbs
	name := a.ReturnName()
	fmt.Println(name)
}