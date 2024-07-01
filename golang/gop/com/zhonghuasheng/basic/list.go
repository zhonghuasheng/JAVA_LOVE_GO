package main

import "fmt"

type U struct {
	Name string
}

type Ur struct {
	T        string
	NameList []*U
}

func main() {
	rst := make([]*U, 0)
	ur := &Ur{
		T:        "x",
		NameList: rst,
	}

	for i := 0; i < 10; i++ {
		rst = append(rst, &U{Name: fmt.Sprintf("%v", i)})
	}
	fmt.Println(ur.NameList)
}
