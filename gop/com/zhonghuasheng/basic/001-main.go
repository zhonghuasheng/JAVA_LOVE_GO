/**
包名
*/
package main

/**
导入格式化包
*/
import (
	"basic/Services"
	"fmt"
	"net/http"

	httptransport "github.com/go-kit/kit/transport/http"
)

/**
main函数入口
*/
func main() {
	fmt.Println("hello go")
	/**
	  测试引入mathClass.go包
	*/
	// addResult := Add(1, 2)
	// fmt.Println(addResult);
	user := Services.UserService{}
	endp := Services.GenUserEndpoint(user)

	serverHandler := httptransport.NewServer(endp, Services.DecodeUserRequest, Services.EncodeUserResponse)
	http.ListenAndServe(":8080", serverHandler)
}
