package main

import "fmt"

// 声明全局变量方法一二三都是可以的
var aa int = 100
var bb = 100

// 用方法四来声明全局变量

func main() {
	// 方法一：声明一个变量 使用默认值
	var a int
	var b string
	fmt.Println(a)
	fmt.Println(b)
	fmt.Printf("type of a = %T\n", a)
	// 方法二： 声明变量，初始化值
	var c string = "hello"
	fmt.Println(c)
	// 方法三：省去类型参数
	var d = 100
	fmt.Println(d)
	// 方法四：(常用) 省去var 冒等
	e := 1001
	fmt.Println(e)

	f := 3.14
	fmt.Println(f)
	fmt.Printf("f %T\n", f)

	// 同一个类型
	var xx, yy int = 100, 200
	fmt.Println(xx, yy)
	// 不同类型
	var kk, ll = 100, "sdfsf"
	fmt.Println(kk, ll)
	// 多行的变量声明
	var (
		vv int  = 100
		jj bool = true
	)
	fmt.Println(vv, jj)
}
