package main

import (
	"fmt"
	"net"
)

type Server struct {
	Ip string
	Port int
}

// NewServer 创建Server结构体
func NewServer(ip string, port int) *Server {
	newServer := &Server{
		Ip: ip,
		Port: port,
	}
	return newServer
}

// 
func (server *Server) Handler(conn net.Conn) {
	// 当前的连接
	fmt.Println("连接建立成功")
}

// 启动服务
func (server *Server) Start() {
	// socket listener
	listener, err := net.Listen("tcp", fmt.Sprintf("%s:%d", server.Ip, server.Port))
	if err != nil {
		fmt.Println("net.Listen err:", err)
	}
	// socket close
	defer listener.Close()
	// accept
	for {
		conn, err := listener.Accept()
		if err != nil {
			fmt.Println("listener accept err:", err)
			continue
		}
		// handler
		go server.Handler(conn)
	}
}