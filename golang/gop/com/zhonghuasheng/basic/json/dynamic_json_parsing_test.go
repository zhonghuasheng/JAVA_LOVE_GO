package json

import (
	"encoding/json"
	"fmt"
	"testing"
)

/**
https://mp.weixin.qq.com/s/mW1Dgj6bZ0gDOwEhCc6jzg
Go 语言的空接口(interface{})为动态 JSON 解析提供了一种灵活的解决方案，允许我们使用任意数据类型。
此外，这种方法消除了定义结构体的需求，使代码能够适应不断变化的 JSON 结构。
注意： json强转到map时携带了数据类型
*/

func TestParseDynamicJson(t *testing.T) {
	// 初始化json字节数组
	jsonData := []byte(`{
		"name": "Bob",
		"age": 30,
		"city": "China",
		"hasCar": true,
		"languages": ["Go", "JavaScript"]
	}`)
	// 解析json到 interface{}动态类型
	var result interface{}
	err := json.Unmarshal(jsonData, &result)
	if err != nil {
		fmt.Println("Parse json err:", err)
	}
	// 将interface{}动态类型，强转为map
	dataMap, ok := result.(map[string]interface{})
	if !ok {
		fmt.Println("json结构体不合法")
	}
	// 取出字段
	name, nameExists := dataMap["name"].(string)
	if nameExists {
		fmt.Println("name: ", name)
	}
	age, ageExist := dataMap["age"].(float64) // 不是int类型
	if ageExist {
		fmt.Println("age: ", age)
	}
	hasCar, hasCarExists := dataMap["hasCar"].(bool)
	if hasCarExists {
		fmt.Println("hasCar: ", hasCar)
	}
	languages, languagesExists := dataMap["languages"].([]interface{})
	if languagesExists {
		for _, l := range languages {
			fmt.Println("languages: ", l)
		}
	}
}
