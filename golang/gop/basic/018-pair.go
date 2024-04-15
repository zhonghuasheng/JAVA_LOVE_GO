package main

import "fmt"

func main() {

	// 反射的变量结构
	var name string
	// pair<type: static type string, value: luke>
	name = "luke"
	var allType interface{}
	allType = name
	value, ok := allType.(string)
	fmt.Println(value)
	fmt.Println(ok)
}
