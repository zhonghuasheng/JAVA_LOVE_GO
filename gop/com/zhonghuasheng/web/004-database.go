package main

import (
	"database/sql"
	"fmt"

	_ "github.com/go-sql-driver/mysql"
)

func main() {
	db, err := sql.Open("mysql", "luke:Abcd1234_@tcp(49.235.118.8:3306)/guestdb?charset=utf8")
	err2 := db.Ping()
	if err != nil {
		fmt.Println(err)
	}
	if err2 != nil {
		fmt.Println(err2)
	}
}
