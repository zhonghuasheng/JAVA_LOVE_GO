package main

import "fmt"

func main() {
    // defer类似C语言的析构函数，在程序的最后会执行（类似java finalize 在垃圾收集器执行的时候会调用被回收对象的此方法）
    defer fmt.Println("main end1") // 多个defer函数体 会按照栈的方式FILO的方式执行
    defer fmt.Println("main end2")
    fmt.Println("hello")
}
