package testencode

import (
	"encoding/base64"
	"encoding/json"
	"fmt"
	"testing"

	"github.com/golang/protobuf/proto"
)

type User struct {
	name string
	attr string
}

func TestEncode(t *testing.T) {
	bigStr := "你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好" +
		"你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好" +
		"你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好" +
		"你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好"
	u := &User{
		name: bigStr,
		attr: bigStr,
	}
	jsonStr, err := json.Marshal(u)
	if err != nil {
		panic(err)
	}
	fmt.Println("JSON字符串长度: ", len(jsonStr))
	data, err := proto.Marshal(u)
	if err != nil {
		panic(err)
	}
	encoded := base64.StdEncoding.EncodeToString(data)
	fmt.Println("encoded字符串长度: ", len(encoded))
}
