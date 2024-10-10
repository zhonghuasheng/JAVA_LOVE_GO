package datatype

import (
	"fmt"
	"testing"
)

type Class struct {
	Num      string
	Level    int
	Students []*Student
}

type Student struct {
	Num  string
	Name string
}

func TestCreateStruct(t *testing.T) {
	c := &Class{
		Num:   "19",
		Level: 2,
		Students: []*Student{ // 嵌套结构体 数据初始化格式
			{
				Num:  "01",
				Name: "bob",
			},
			{
				Num:  "02",
				Name: "joy",
			},
		},
	}
	fmt.Printf("%+v", c)
}
