package main

import (
	"fmt"
	"sync"
)

func main() {
	var scene sync.Map
	scene.Store("greece", 97)
	scene.Store("london", 100)
	scene.Store("egypt", 200)
	fmt.Println(scene.Load("london"))
}