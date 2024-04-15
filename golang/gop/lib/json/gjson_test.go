package json

import (
	"fmt"
	"github.com/tidwall/gjson"
	"testing"
)

func TestGJson(t *testing.T) {
	var json = `{"name": {"first":"Tom", "last": "Jones"},"age":37,"children": ["Sara","Alex"], "big_num":"231431234324234242"}`
	// 使用方式1
	value := gjson.Get(json, "name")
	fmt.Println(value)
	// 使用方式2
	g := gjson.Parse(json)
	fmt.Println(g.Get("big_num").Int())
}
