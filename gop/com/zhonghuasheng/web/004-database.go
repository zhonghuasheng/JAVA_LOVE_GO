package main

import (
	"database/sql"
	"fmt"
	"time"

	_ "github.com/go-sql-driver/mysql"
)

func main() {
	db, err := sql.Open("mysql", "xxx:xxxx@tcp(49.235.118.8:3306)/guestdb?charset=utf8")

	if err != nil {
		fmt.Println(err)
	}

	// // 创建表
	// createSQL := `CREATE TABLE users (
	//     id INT AUTO_INCREMENT,
	//     username TEXT NOT NULL,
	//     password TEXT NOT NULL,
	//     created_at DATETIME,
	//     PRIMARY KEY (id)
	// );`
	// _, createErr := db.Exec(createSQL)
	// if createErr != nil {
	// 	fmt.Println(createErr)
	// }

	// 插入数据
	username := "luke"
	password := "123"
	createdAt := time.Now()
	result, err := db.Exec("INSERT INTO users (username, password, created_at) VALUES(?,?,?)", username, password, createdAt)
	userID, insertErr := result.LastInsertId()
	fmt.Println("LastInsertId =", userID)
	if insertErr != nil {
		fmt.Println(insertErr)
	}
}
