package main

import (
    "container/list"
    "fmt"
)

func main() {
    l := list.New()
    l.PushBack("a")
    l.PushFront("b") // b a
    printList(l)
    element := l.PushBack("c") // b a c
    printList(l)
    // 要使用element句柄，在元素c之前插入; 根据句柄来移动
    l.InsertBefore("d", element) // b a d c
    printList(l)
    l.InsertAfter("e", element) // b a d c e
    printList(l)
    l.InsertAfter("f", element) // b a d c f e
    printList(l)
}

// 遍历元素
func printList(l *list.List) {
    for i := l.Front(); i != nil; i = i.Next() {
        fmt.Print(i.Value)
    }
    fmt.Println()
}
