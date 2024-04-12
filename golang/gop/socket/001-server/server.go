package main

import (
	"fmt"
	"io"
	"net"
	"sync"
)

// Server 服务器
type Server struct {
	IP          string           // ip地址
	Port        int              // 端口
	OnlineMap   map[string]*User // 在线用户
	mapLock     sync.RWMutex
	MessageChan chan string // 广播消息的channel
}

// NewServer 新建服务结构体
func NewServer(ip string, port int) *Server {
	newServer := &Server{
		IP:          ip,
		Port:        port,
		OnlineMap:   make(map[string]*User),
		MessageChan: make(chan string),
	}
	return newServer
}

func (s *Server) Handler(conn net.Conn) {
	//fmt.Println("连接建立成功")
	//fmt.Println(conn.LocalAddr().String())
	// 用户上线
	user := NewUser(conn)
	s.mapLock.Lock()
	s.OnlineMap[user.Name] = user
	s.mapLock.Unlock()
	// 广播当前用户上线消息
	s.BroadCast(user, "已上线")
	// 接收用户的消息
	go func() {
		buf := make([]byte, 4096)
		for {
			n, err := conn.Read(buf)
			// 读取长度为0
			if n == 0 {
				s.BroadCast(user, "已下线")
				return
			}
			// 错误 或者 (读完了 EOF)
			if err != nil && err != io.EOF {
				fmt.Println("Conn Read err:", err)
				return
			}
			// 提取用户的消息(去除\n)
			msg := string(buf[:n-1])
			// 将得到的消息进行广播
			s.BroadCast(user, msg)
		}
	}()
	// TODO 阻塞当前handler
	select {}
}

// BroadCast 消息广播
func (s *Server) BroadCast(user *User, msg string) {
	sendMsg := fmt.Sprintf("[%s] %s : %s", user.Addr, user.Name, msg)
	s.MessageChan <- sendMsg
}

// ListenMessageChan 将广播消息发给用户
func (s *Server) ListenMessageChan() {
	for {
		msg := <-s.MessageChan
		s.mapLock.Lock()
		fmt.Println(s.OnlineMap)
		for _, cli := range s.OnlineMap {
			cli.C <- msg
		}
		s.mapLock.Unlock()
	}
}

func (s *Server) Start() {
	// 监听
	listener, err := net.Listen("tcp", fmt.Sprintf("%s:%d", s.IP, s.Port))
	if err != nil {
		fmt.Println("net.Listen failed", err)
	}
	// 关闭连接
	defer listener.Close()
	// 启动监听广播
	go s.ListenMessageChan()
	// accept
	for {
		fmt.Println("???这里一直运行")
		conn, err := listener.Accept() // 会阻塞在这里，知道有连接过来。然后接着阻塞在这里
		if err != nil {
			fmt.Println("listener.Accept failed", err)
			continue // 继续监听
		}
		// 不报错则走handler处理
		go s.Handler(conn)
	}
}
