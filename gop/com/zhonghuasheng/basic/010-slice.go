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
}

// 引用传递，传递的是指针
func printArray2(myArray []int) {
    for index, value := range myArray {
        fmt.Println("index=", index, ", value=", value)
    }
    myArray[0] = 123
}
