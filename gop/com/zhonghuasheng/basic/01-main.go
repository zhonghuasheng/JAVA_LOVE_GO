/**
包名
 */
package main

/**
导入格式化包
 */
import (
    "fmt"
)

/**
main函数入口
 */
func main() {
    fmt.Println("hello go")
    /**
    测试引入mathClass.go包
     */
    addResult := Add(1, 2)
    fmt.Println(addResult);
}

