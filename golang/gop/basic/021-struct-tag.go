package main

import (
	"fmt"
	"reflect"
)

/**
结构体标签
*/

type resume struct {
	Name string `info:"name" doc:"结构体标签"`
	Age  int    `info:"age"`
}

func main() {
	var r resume
	showTag(&r)
}

func showTag(input interface{}) {
	elem := reflect.TypeOf(input).Elem()
	for i := 0; i < elem.NumField(); i++ {
		infoTag := elem.Field(i).Tag.Get("info")
		docTag := elem.Field(i).Tag.Get("doc")
		fmt.Println("infoTag=", infoTag, "docTag=", docTag)
	}
}
