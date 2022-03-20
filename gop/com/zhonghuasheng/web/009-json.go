package main

import (
	"encoding/json"
	"fmt"
	"net/http"
)

type User struct {
	FirstName string `json:"firstname"`
	LastName  string `json:"lastname"`
	Age       int    `json:"age"`
}

func main() {
	http.HandleFunc("/decode", func(w http.ResponseWriter, r *http.Request) {
		var user User
		json.NewDecoder(r.Body).Decode(&user)
		fmt.Fprintf(w, "%s %s %s", user.FirstName, user.LastName, user.Age)
	})

	http.HandleFunc("/encode", func(w http.ResponseWriter, r *http.Request) {
		luke := User{
			FirstName: "Luke",
			LastName:  "Chen",
			Age:       25,
		}
		json.NewEncoder(w).Encode(luke)
	})
	http.ListenAndServe(":8080", nil)
	// curl -s -XPOST -d '{"firstname":"1", "lastname":"2", "age":3}' http://localhost:8080/decode
	// curl -s http://localhost:8080/encode
}
