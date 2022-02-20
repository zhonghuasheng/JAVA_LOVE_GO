package main

import "fmt"

type Human struct {
	Name string
}

func (people Human) getName() string {
	return people.Name
}

func (people Human) setName(newName string) {
	people.Name = newName
}

func main() {
	// 创建一个对象
	p := Human{Name: "Luke Chen"}
	fmt.Println(p.getName())
	p.setName("Zhang San")
	fmt.Println(p) // 打印出来的还是Luke Chen
	p.setName2("ttttt")
	fmt.Println(p)
}

func (people *Human) getName2() string {
	return people.Name
}

func (people *Human) setName2(newName string) {
	people.Name = newName
}
