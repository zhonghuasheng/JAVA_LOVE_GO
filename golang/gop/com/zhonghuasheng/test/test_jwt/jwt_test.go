package testjwt_test

import (
	"fmt"
	"testing"
	"time"

	"github.com/dgrijalva/jwt-go"
)

func TestJwt(t *testing.T) {
	tokenStr := getToken("123", "abc")
	verifyToken(tokenStr)
}

func getToken(id, username string) string {
	token := jwt.NewWithClaims(jwt.SigningMethodHS256, jwt.MapClaims{
		"id":       id,
		"username": username,
		"exp":      time.Now().Add(time.Hour * 72).Unix(),
	})
	tokenStr, err := token.SignedString([]byte("test"))
	if err != nil {
		fmt.Printf("error: %+v", err)
		return ""
	}
	return tokenStr
}

func verifyToken(tokenStr string) bool {
	// 解析令牌
	token, err := jwt.Parse(tokenStr, func(token *jwt.Token) (interface{}, error) {
		if _, ok := token.Method.(*jwt.SigningMethodHMAC); !ok {
			return nil, fmt.Errorf("unexpected signing method: %v", token.Header["alg"])
		}
		return []byte("secret"), nil
	})

	if err != nil {
		fmt.Printf("Error parsing token: %v\n", err)
		return false
	}

	if claims, ok := token.Claims.(jwt.MapClaims); ok && token.Valid {
		fmt.Printf("Token is valid. Claims: %v\n", claims)
		return true
	} else {
		fmt.Printf("Token is not valid.\n")
		return false
	}
}
