package main

import "fmt"

// 如果类的首字母大写，表示其他包能够访问
type Human struct {
	Name string // 首字母大写 public
	age  int    // 首字母小写 private
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
	fmt.Println("p=", p, " &p=", &p) // p= {ttttt 0}  &p= &{ttttt 0}
}

// 我觉得结构体和结构体指针 可以认为是一个意思，需要区别的是传指针可以修改结构体的字段的值
func (people *Human) getName2() string {
	return people.Name
}

func (people *Human) setName2(newName string) {
	people.Name = newName
}
