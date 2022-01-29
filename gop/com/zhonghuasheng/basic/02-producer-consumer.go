package main

import (
    "fmt"
    _ "fmt"
    "math/rand"
    _ "math/rand"
    "time"
    _ "time"
)
func main() {
    channel :=make(chan string)
    go producer("cat", channel)
    go producer("dog", channel)
    consumer(channel)
}

func producer(header string, channel chan<- string) {
    for {
        channel <- fmt.Sprintf("%s: %v", header, rand.Int31())
        time.Sleep(time.Second)
    }
}

func consumer(channel <-chan string) {
    for {
        message := <-channel
        fmt.Println(message)
    }
}
