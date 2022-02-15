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

	// append为数组添加元素
	arr2 := []int{1, 2, 3}
	arr2 = append(arr2, 4) // 在末尾追加一个元素
	fmt.Println(arr2)
	arr2 = append(arr2, 5, 6, 7) // 在末尾追加多个元素
	fmt.Println(arr2)
	arr2 = append(arr2, []int{8, 9}...) //在末尾追加一个切片
	fmt.Println(arr2)
	arr2 = append([]int{-2, -1, 0}, arr2...) // 在切片开头追加元素，相当于在添加的切片末尾追加当前切片
	fmt.Println(arr2)
	ints := arr2[:2] // 取第0到2的元素
	fmt.Println(ints)
	i2 := arr2[2:4] // 取第2到4的元素
	fmt.Println(i2)
	i3 := append(arr2[:3], append([]int{100}, arr2[3:]...)...) // 在第3个位置追加切片
	fmt.Println(i3)
	// 数组2倍扩容
	var num []int
	for i := 0; i < 10; i++ {
		num = append(num, i)
		fmt.Printf("num len=%d cap=%d pointer=%p \n", len(num), cap(num), num)
	}
}

// 引用传递，传递的是指针
func printArray2(myArray []int) {
	for index, value := range myArray {
		fmt.Println("index=", index, ", value=", value)
	}
	myArray[0] = 123
}
