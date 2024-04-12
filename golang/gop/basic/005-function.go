package main

import "fmt"

/**
函数
	* 多返回值
	* init函数
*/
func main() {
	c := fool("a", 2)
	fmt.Println(c)
	d, e := fool2("d", 2)
	fmt.Printf("d=%v, e=%v", d, e)
	re1, re2 := fool3("ads", 3)
	fmt.Printf("re1 = %v, re2 = %v", re1, re2)
	re3, re4 := fool4("ads", 3)
	fmt.Printf("re1 = %v, re2 = %v", re3, re4)
}

// 单个返回值
func fool(a string, b int) int {
	fmt.Println(a)
	fmt.Println(b)
	c := 100
	return c
}

// 多返回值，匿名
func fool2(a string, b int) (int, int) {
	return 666, 777
}

// 多返回值，实名
func fool3(a string, b int) (r int, z int) {
	return 444, 555
}

// 多返回值，实名
func fool4(a string, b int) (r, z int) {
	r = 6
	z = 7
	return
}
