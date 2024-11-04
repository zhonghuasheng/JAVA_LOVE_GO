package reflect

import (
	"fmt"
	"reflect"
	"testing"
)

type User struct {
	Name string `json:"name"`
	Age  int    `json:"age"`
}

func TestSetUser(t *testing.T) {
	u := &User{}
	data := map[string]interface{}{
		"Name": "luke",
		"Age":  18,
	}
	assignMapToStruct(data, u)
	fmt.Println(u)
	u2 := &User{}
	assignMapToStruct2(u2, data)
	fmt.Println(u2)
}

func assignMapToStruct(data map[string]interface{}, obj interface{}) error {
	v := reflect.ValueOf(obj).Elem()
	t := v.Type()

	for i := 0; i < t.NumField(); i++ {
		field := t.Field(i)
		fieldName := field.Name
		fieldValue := v.Field(i)

		if value, ok := data[fieldName]; ok {
			valueType := reflect.TypeOf(value)
			if valueType.Kind() == reflect.Ptr && valueType.Elem().Kind() == reflect.String {
				value = reflect.ValueOf(value).Elem().Interface()
			}

			if reflect.TypeOf(fieldValue.Interface()) == valueType {
				fieldValue.Set(reflect.ValueOf(value))
			} else {
				return fmt.Errorf("type mismatch for field %s: expected %s, got %s", fieldName, fieldValue.Type(), valueType)
			}
		}
	}

	return nil
}

func assignMapToStruct2(user *User, data map[string]interface{}) error {
	structValue := reflect.ValueOf(user).Elem()
	for key, value := range data {
		field := structValue.FieldByName(key)
		if !field.IsValid() || !field.CanSet() {
			continue // 字段不存在或者不可设置
		}

		valueType := reflect.TypeOf(value)
		fieldType := field.Type()

		// 如果字段是指针类型，需要解引用比较
		if fieldType.Kind() == reflect.Ptr {
			if valueType.Kind() != reflect.Ptr || fieldType.Elem() != valueType.Elem() {
				continue // 类型不匹配
			}
			field.Set(reflect.ValueOf(value)) // 直接设置值
		} else {
			if valueType != fieldType {
				continue // 类型不匹配
			}
			field.Set(reflect.ValueOf(value)) // 直接设置值
		}
	}
	return nil // 或者返回实际发生的错误
}
