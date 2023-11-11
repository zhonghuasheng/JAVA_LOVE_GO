package main

import "fmt"

// 利用struct实现面向对象中封装的特性
type Food struct {
	name string // 属性，小写，对外不可见
}

func (f *Food) getFoodName() {
	fmt.Println(f.name)
}

// 继承 Tomato拥有了Food的所有特性
type Tomato struct {
	Food // 匿名字段，可以直接用Tomato的对象.name使用
}

func main() {
	f := Food{name: "西红柿"}
	f.getFoodName()

	t := Tomato{Food{name: "西红柿2号"}}
	t.getFoodName()
}
