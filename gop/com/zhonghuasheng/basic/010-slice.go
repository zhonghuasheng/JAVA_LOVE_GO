package main

import "fmt"

func main() {
    // 切片 slice 也叫动态数组
    myArray := []int{1, 2, 3, 4}
    for index, value := range myArray {
        fmt.Println("index=", index, ", value=", value)
    }
    fmt.Printf("myArray type is %T\n", myArray) //[]int
    printArray2(myArray)
    
    for index, value := range myArray {
        fmt.Println("index=", index, ", value=", value)
    }
    // 数组切片
    ints := myArray[0:2] // 切出来的时候左闭右开
    fmt.Println(ints)
    // 使用make()函数构造切片 make([]type, size, cap)
    // 其中 Type 是指切片的元素类型，size 指的是为这个类型分配多少个元素，cap 为预分配的元素数量，这个值设定后不影响 size，只是能提前分配空间，降低多次分配空间造成的性能问题。
    a := make([]int, 2)
    fmt.Println(a, len(a))
    b := make([]int, 2, 10)
    fmt.Println(b, len(b))
    // 其中 a 和 b 均是预分配 2 个元素的切片，只是 b 的内部存储空间已经分配了 10 个，但实际使用了 2 个元素。
    // 容量不会影响当前的元素个数，因此 a 和 b 取 len 都是 2。
}

// 引用传递，传递的是指针
func printArray2(myArray []int) {
    for index, value := range myArray {
        fmt.Println("index=", index, ", value=", value)
    }
    myArray[0] = 123
}
