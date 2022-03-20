package main

import (
	"fmt"
	"log"
	"net/http"
)

func foo(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "foo")
}

/**
 * 以http.HandlerFunc作为参数，返回的是http.HandlerFunc，相当于做了一层外层
 */
func logging(f http.HandlerFunc) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		log.Println(r.URL.Path) // 记录请求地址
		f(w, r)                 // 继续请求处理
	}
}

func main() {
	// http.HandleFunc("/foo", foo) // 这种写法是没有问题的
	http.HandleFunc("/foo", logging(foo))
	http.ListenAndServe(":8080", nil)
}
