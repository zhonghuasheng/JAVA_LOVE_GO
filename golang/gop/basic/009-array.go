package main

import "fmt"

func main() {
	// 固定长度的数组，初始化默认值都是0
	var myArray [10]int
	for i := 0; i < len(myArray); i++ {
		fmt.Println(myArray[i])
	}
	myArray2 := [10]int{1, 2, 3, 4}
	for index, value := range myArray2 {
		fmt.Println("index=", index, ", value=", value)
	}
	// 查看数组的数据类型
	fmt.Printf("myArray type is %T\n", myArray)
	fmt.Printf("myArray2 type is %T\n", myArray2)
	myArray3 := [4]int{1, 2, 3, 4}
	fmt.Printf("myArray3 type is %T\n", myArray3)
	/** 数组根据不同的长度有不同的数据类型
	  myArray type is [10]int
	  myArray2 type is [10]int
	  myArray3 type is [4]int
	*/
	printArray(myArray3)
	// 如果传一个[10]int的数组，编译直接报错
	//printArray(myArray)
}

func printArray(myArray [4]int) {
	// 值拷贝
	for index, value := range myArray {
		fmt.Println("index=", index, ", value=", value)
	}
}
