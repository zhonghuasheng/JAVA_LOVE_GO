package main

import "fmt"

/**
常量
const可以定义枚举类型
iota只能配合cons()一起使用
*/
const (
	BEIJING   = 0
	SHANGHAI  = 1
	SHENZHENG = 2
)

// go中提供了一个关键字iota，每行的iota都会累加1  注意是行
const (
	A = iota // iota=0
	B        // iota=1
	C        // iota=2
)

const (
	A2 = 10 * iota // iota=0
	B2             // iota=1
	C2             // iota=2
)

const (
	a, b = iota + 1, iota + 2 // iota=0, a=1, b = 2
	c, d                      // iota=1, c=iota+1, d=iota+2
	e, f                      // iota=2, e=iota+1, d=iota+2
	g, h = iota * 2, iota * 3 // iota=3, g=6,h=9
	i, k                      // iota=4, i=iota*2 8 k=iota*3 12
)

func main() {
	// 常量（只读属性）
	const length int = 20
	fmt.Println(length)
	fmt.Println(BEIJING)
	fmt.Println(C)  // 2
	fmt.Println(C2) // 20
	fmt.Println(k)
}
