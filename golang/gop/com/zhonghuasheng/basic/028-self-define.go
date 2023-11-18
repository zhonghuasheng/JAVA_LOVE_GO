package main

import "fmt"

func main() {
	type (
		user struct {
			name string
			age  uint8
		}
		event func(string) bool
	)
	u := user{"Tome", 20}
	fmt.Println(u)
	var f event = func(s string) bool {
		println(s)
		return s != ""
	}
	f("abc")
}

取址运算符“&”用于获取对象地址。
指针运算符“*”用于间接引用目标对象。