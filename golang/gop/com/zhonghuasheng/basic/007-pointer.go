package main

import "fmt"

func changeValue(p int) {
	p = 10
}

func changeValue2(p *int) { // 接受的是指针
	*p = 11
}

func main() {
	a := 1
	changeValue(a)
	fmt.Println(a)   // go语言中走的是值传递
	changeValue2(&a) // 传的是指针地址
	fmt.Println(a)
	// 经典的值传递
	var b int = 1
	var c int = 2
	swap1(b, c)
	fmt.Println("b=, c=", b, c)
	var d int = 3
	var e int = 4
	swap2(&d, &e)
	fmt.Println("d= e=", d, e)

	var p *int
	p = &a
	fmt.Println("&a=", &a)
	fmt.Println("p =", p)
	// 二级指针
	var pp **int
	pp = &p
	fmt.Println("&p=", &p)
	fmt.Println("pp=", pp)
}

func swap1(a int, b int) {
	var temp = a
	a = b
	b = temp
}

func swap2(pa *int, pb *int) {
	var temp int
	temp = *pa
	*pa = *pb
	*pb = temp
}
