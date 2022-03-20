package main

import (
	"database/sql"
	"fmt"

	_ "github.com/go-sql-driver/mysql"
)

func main() {
	db, err := sql.Open("mysql", "user:password@tcp(49.235.118.8:3306)/guestdb?charset=utf8")

	if err != nil {
		fmt.Println(err)
	}

	// 创建表
	createSQL := `CREATE TABLE users (
        id INT AUTO_INCREMENT,
        username TEXT NOT NULL,
        password TEXT NOT NULL,
        created_at DATETIME,
        PRIMARY KEY (id)
    );`
	_, createErr := db.Exec(createSQL)
	if createErr != nil {
		fmt.Println(createErr)
	}
}
