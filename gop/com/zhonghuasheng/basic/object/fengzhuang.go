package object

import "fmt"

type Food struct {
	name string // 属性，小写，对外不可见
}

func (f *Food) getFoodName() {
	fmt.Println(f.name)
}

func main() {
	f := Food{name: "西红柿"}
	f.getFoodName()
}
