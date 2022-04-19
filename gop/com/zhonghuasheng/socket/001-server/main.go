package main

func main() {
	server := NewServer("127.0.0.1", 8888)
	server.Start()
	/**
	go build server -o main.go server.go
	./server
	另起一个终端 nc 127.0.0.1 8888
	**/
}