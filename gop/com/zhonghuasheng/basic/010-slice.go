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

	// append为切片动态添加元素
	var c []int
	c = append(c, 1)
	c = append(c, 1, 2, 3)
	c = append(c, []int{4, 5, 6}...) // 追加一个切片，切片需要解包
	fmt.Println(c)
	append2()
}

// 引用传递，传递的是指针
func printArray2(myArray []int) {
	for index, value := range myArray {
		fmt.Println("index=", index, ", value=", value)
	}
	myArray[0] = 123
}

func append2() {
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
	// 切片 slice 也叫动态数组
	myArray := []int{1, 2, 3, 4}
	for index, value := range myArray {
		fmt.Println("index=", index, ", value=", value)
	}
	fmt.Printf("myArray type is %T\n", myArray) //[]int
	printArray2(myArray)
}
