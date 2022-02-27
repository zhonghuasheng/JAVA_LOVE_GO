package main

import (
	"fmt"
	"reflect"
)

func reflectTest(arg interface{}) {
	fmt.Println("type: ", reflect.TypeOf(arg))
	fmt.Println("value: ", reflect.ValueOf(arg))
}

func main() {
	// 简单类型反射
	f := 1.2345
	reflectTest(f)
}
