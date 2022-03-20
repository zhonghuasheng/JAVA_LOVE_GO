package main

import (
	"fmt"
	"log"
	"net/http"
	"time"
)

/**
 * type X 类型名，此处类型名是 func(http.HandlerFunc) http.HandlerFunc，是一个
 */
type Middleware func(http.HandlerFunc) http.HandlerFunc

// 记录请求时间
func Logging() Middleware {
	return func(hf http.HandlerFunc) http.HandlerFunc {
		return func(w http.ResponseWriter, r *http.Request) {
			start := time.Now()
			defer func() { log.Println(r.URL.Path, time.Since(start)) }()
			hf(w, r)
		}
	}
}

// 拦截请求类型
func Method(m string) Middleware {
	return func(hf http.HandlerFunc) http.HandlerFunc {
		return func(w http.ResponseWriter, r *http.Request) {
			fmt.Println(r.Method)
			if r.Method != m {
				http.Error(w, http.StatusText(http.StatusBadRequest), http.StatusBadRequest)
				return
			}
			hf(w, r)
		}
	}
}

// 请求拦截链
func Chain(f http.HandlerFunc, middlewares ...Middleware) http.HandlerFunc {
	for _, m := range middlewares {
		f = m(f)
	}
	return f
}

func Hello(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "hello world")
}

func main() {
	http.HandleFunc("/", Chain(Hello, Method("GET"), Logging())) // /的请求，会执行 Chain(Hello, Method("GET"), Logging())整个逻辑
	http.ListenAndServe(":8080", nil)
}
