package main

import "fmt"

type Foo interface {
	qux()
}

type Bar struct{}
type Baz struct{}

func (b Bar) qux() {
	fmt.Println("Bar实现了qux")
}

func (b Baz) qux() {
	fmt.Println("Baz实现了qux")
}

// 多肽的实现
func main() {
	var f Foo
	f = Bar{}
	f.qux()
	f = Baz{}
	f.qux()
}
