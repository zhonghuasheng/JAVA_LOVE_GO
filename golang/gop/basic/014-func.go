package main

import (
	"fmt"
)

// Person 人员结构体
type Person struct {
	age int
}

// SetAge 设置人员的年龄
// 如果方法的接收者是值类型，无论调用和是对象还是对象指针，修改的都是对象的副本，不会影响调用者
// 如果实现了接收者是值类型的方法，会隐含地实现接收者是指针类型的方法
func (p Person) SetAge(newAge int) {
	p.age = newAge // 接收器是p结构体，不会影响原结构体age
}

// SetAge 设置人员的年龄
// 如果方法的接收者是指针类型，无论调用者是对象还是对象指针，修改的都是对象本身，会影响调用者
// 如果实现了接收者是指针类型的方法，会隐含地实现接收者是值类型的方法
func (p *Person) SetAge2(newAge int) {
	p.age = newAge // 接收器是p结构体指针，影响原结构体age
}

func main() {
	p := Person{age: 1}
	p.SetAge(2)
	fmt.Println(p.age) // 结果是1
	p.SetAge2(3)
	fmt.Println(p.age) // 结果是3。
	// 问题来了，我没有使用结构体指针调用SetAge2，为什么呢？
	p2 := &Person{age: 1}
	p2.SetAge(2)
	fmt.Println(p2.age)
	p2.SetAge2(3)
	fmt.Println(p2.age)
}