package main

import "fmt"

// 声明一种新的数据类型 myint，是int的一个别名
type myint int

// 定义一个结构体 是个复杂的类型
type Book struct {
	title  string
	author string
}

func changeBook(book Book) {
	// 不会改变author的值
	book.author = "666"
}

func changeBook2(book *Book) {
	// 指针传递
	book.author = "777"
}

func main() {
	var a myint = 10
	fmt.Println("a = ", a)
	// 打印a的类型
	fmt.Printf("type of a = %T\n", a)
	book1 := Book{title: "hello world", author: "Luke Chen"}
	fmt.Println(book1)
	var book2 Book
	book2.title = "Golang"
	book2.author = "Zhang"
	fmt.Println(book2)
	changeBook(book2)
	fmt.Println(book2)
	changeBook2(&book2)
	fmt.Println(book2)
}
