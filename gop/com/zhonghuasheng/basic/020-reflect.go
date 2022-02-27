package main

import (
	"fmt"
	"reflect"
)

type User struct {
	Name string
	Age  int
}

func (this User) Call() {
	fmt.Println(this)
}

func main() {
	user := User{Name: "Luke", Age: 18}
	reflectFieldAndMethod(user)
}

func reflectFieldAndMethod(input interface{}) {
	// 获取input type value
	inputType := reflect.TypeOf(input)
	inputValue := reflect.ValueOf(input)
	fmt.Printf("inputType=%v, inputValue=%v", inputType, inputValue)
	// 获取input的field
	for i := 0; i < inputType.NumField(); i++ {
		field := inputType.Field(i)
		fmt.Println("fieldName= ", field.Name)
		fmt.Println("fieldValue", inputValue.Field(i).Interface())
	}
	// 获取input中的方法
	for i := 0; i < inputType.NumMethod(); i++ {
		method := inputType.Method(i)
		fmt.Printf("%s, %v\n ", method.Name, method.Type)
	}
}
