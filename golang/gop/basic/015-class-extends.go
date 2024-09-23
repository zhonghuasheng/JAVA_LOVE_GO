package main

import "fmt"

type Parent struct {
	name string
	age  int
}

func (this *Parent) Eat() {
	fmt.Println("Parent.Eat()...")
}

func (this *Parent) Walk() {
	fmt.Println("Parent.Walk()...")
}

// 子类
type Child struct {
	Parent // 继承父类Parent
	level  int
}

func (this *Child) Eat() {
	fmt.Println("Child.Eat()... name=", this.name)
}

func (this *Child) Stu() {
	fmt.Println("Child.Stu()...")
}

func main() {
	p := Parent{"zhang", 12}
	p.Eat()
	p.Walk()
	c := Child{Parent{"Chen", 11}, 1}
	c.Eat()  // 子类方法
	c.Walk() // 父类方法
	c.Stu()  // 子类方法
	c.name = "Luke"
	c.Eat()
}
