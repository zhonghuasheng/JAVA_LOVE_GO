package main

import (
	"fmt"
	"net"
)

// User 用户结构体
type User struct {
	Name string      // 用户名
	Addr string      // 客户端ip地址
	C    chan string // 当前用户绑定的channel
	conn net.Conn    // 与当前用户通信的连接
}

// NewUser 创建一个新用户
func NewUser(conn net.Conn) *User {
	userAddr := conn.RemoteAddr().String()
	user := &User{
		Name: userAddr,
		Addr: userAddr,
		C:    make(chan string),
		conn: conn,
	}
	fmt.Println(userAddr)
	// 启动监听当前user channel消息的goroutine
	go user.ListenMessage()
	return user
}

// ListenMessage 监听当前User channel，一旦有来自server的消息，就直接发给客户端
func (u *User) ListenMessage() {
	for {
		msg := <-u.C
		u.conn.Write([]byte(msg + "\n"))
	}
}
