package main

import (
	"fmt"
)

// 定义一个接口，本质是一个指针
type Animal interface {
	Sleep()
	GetColor() string
}

// 定义一个类，实现接口的方法
type Dog struct {
	color string
}

func (this *Dog) Sleep() {
	fmt.Println("Dog sleep")
}

func (this *Dog) GetColor() string {
	return this.color
}

type Cat struct {
	color string
}

func (this *Cat) Sleep() {
	fmt.Println("Cat sleep")
}

func (this *Cat) GetColor() string {
	return this.color
}

func main() {
	// 第一种调用方式：cat和dog都实现了Animal，对其中的方法也都实现了，多态的本质
	var animal Animal
	animal = &Dog{color: "Yello"}
	animal.Sleep()
	fmt.Println(animal.GetColor())
	animal = &Cat{color: "White"}
	animal.Sleep()
	fmt.Println(animal.GetColor())
	fmt.Println("---------------")
	// 第二种调用方式
	Show(&Dog{color: "color1"})
	Show(&Cat{color: "color2"})
	//
	cat := Cat{color: "xxx"}
	var aaa interface{} = cat
	fmt.Println(aaa.(Cat)) // 接口.(具体struct) 类似于Java向下转型
}

func Show(animal Animal) {
	animal.Sleep() // 多态
	fmt.Println(animal.GetColor())
}
