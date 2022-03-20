package main

import (
	"fmt"
	"net/http"

	"github.com/gorilla/mux"
)

func main() {
	r := mux.NewRouter()
	r.HandleFunc("/books/{title}/page/{page}", func(w http.ResponseWriter, r *http.Request) {
		vars := mux.Vars(r)
		title := vars["title"]
		page := vars["page"]

		fmt.Fprintf(w, "You've requested the book: %s on page %s\n", title, page)
	})

	// 扩展。将请求与方法绑定
	r.HandleFunc("/band", ReadBook).Methods("GET")

	http.ListenAndServe(":8080", r)
	// http://localhost:8080/books/%E5%B9%B3%E5%87%A1%E7%9A%84%E4%B8%96%E7%95%8C/page/101
}

func ReadBook(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Read book here")
	// http://localhost:8080/band 按照这种特性其实可以扩展一个api method的自动映射
}
