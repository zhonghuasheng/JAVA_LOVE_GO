package main

import (
	"encoding/json"
	"fmt"
)

/**
struct转JSON
json转struct
*/

type Movie struct {
	Title  string   `json:"title"`
	Price  int      `json:"rmb"`
	Actors []string `json:"actors"`
}

func main() {
	movie := Movie{Title: "功夫", Price: 100, Actors: []string{"周星驰", "黄圣依"}}
	// struct -> json jsonStr type是[]byte
	jsonStr, err := json.Marshal(movie)
	if err != nil {
		fmt.Println("struct -> json failed, err=", err)
		return
	}
	fmt.Printf("jsonStr=%s\n", jsonStr)
	// json -> struct
	newMovie := Movie{}
	err = json.Unmarshal(jsonStr, &newMovie)
	if err != nil {
		fmt.Println("jsonStr -> struct failed, err=", err)
	}
	fmt.Println(newMovie)
	// 只匹配与结构体一致的字段
	newStr := `{"title1":"功夫","rmb":100,"actors":["周星驰","黄圣依"]}`
	newMovie1 := Movie{}
	// 入参需为
	err = json.Unmarshal([]byte(newStr), &newMovie1)
	if err != nil {
		fmt.Println("jsonStr -> struct failed, err=", err)
	}
	fmt.Println(newMovie1)
}
