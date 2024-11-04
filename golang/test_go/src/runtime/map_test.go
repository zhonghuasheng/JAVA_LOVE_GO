package runtime

import (
	"fmt"
	"testing"
)

func TestConvertInterfaceToString(t *testing.T) {
	m := make(map[string]interface{}, 3)
	m["key1"] = 1
	m["key2"] = "hello"
	m["key3"] = true

	n := make(map[string]string, len(m))

	for k, v := range m {
		n[k] = fmt.Sprintf("%v", v)
	}
	fmt.Printf("%+v", n)
}
