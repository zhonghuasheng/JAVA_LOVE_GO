package main

import (
	"database/sql"
	"fmt"
	"time"

	_ "github.com/go-sql-driver/mysql"
)

func main() {
	db, err := sql.Open("mysql", "x:xx@tcp(49.235.118.8:3306)/guestdb?charset=utf8&parseTime=true")

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

	// // 插入数据
	// username := "luke"
	// password := "123"
	// createdAt := time.Now()
	// result, err := db.Exec("INSERT INTO users (username, password, created_at) VALUES(?,?,?)", username, password, createdAt)
	// userID, insertErr := result.LastInsertId()
	// fmt.Println("LastInsertId =", userID)
	// if insertErr != nil {
	// 	fmt.Println(insertErr)
	// }

	// 查询单条数据
	var (
		id        int
		username  string
		password  string
		createdAt time.Time
	)
	selectQuery := "SELECT id, username, password, created_at FROM users WHERE id = ?"
	selectErr := db.QueryRow(selectQuery, 1).Scan(&id, &username, &password, &createdAt)
	if selectErr != nil {
		fmt.Println(selectErr)
	}
	fmt.Printf(" id=%d \n username=%s \n password=%s \n createdAt=%s \n", id, username, password, createdAt)

	// 查询所有数据
	rows, err := db.Query("SELECT id, username, password, created_at FROM users")
	defer rows.Close()
	var users []user
	for rows.Next() {
		var u user
		selectAllErr := rows.Scan(&u.id, &u.username, &u.password, &u.createdAt)
		if selectAllErr != nil {
			continue
		}
		fmt.Println(u)
		users = append(users, u)
	}
	rowsErr := rows.Err()
	if rowsErr != nil {
		fmt.Println(rowsErr)
	}
	fmt.Println(users)
	fmt.Println(users[0])
}

type user struct {
	id        int       `json:"id"`
	username  string    `json:"username"`
	password  string    `json:"password"`
	createdAt time.Time `json:"createdAt"`
}
