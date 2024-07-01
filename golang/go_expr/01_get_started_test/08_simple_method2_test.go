package getstartedtest

import (
	"fmt"
	"testing"

	"github.com/antonmedv/expr"
)

type MM struct{}

func (MM) GetNameMap(name string) map[string]interface{} {
	return map[string]interface{}{
		"name": name,
		"age":  12,
	}
}

func TestSimpleMe(t *testing.T) {
	env := MM{}
	var methodName = "GetNameMap"
	var name = "bob"
	code := fmt.Sprintf("%v(\"%v\")", methodName, name)
	program, _ := expr.Compile(code, expr.Env(env))
	rst, _ := expr.Run(program, env)
	rstMap := rst.(map[string]interface{})
	fmt.Println(rstMap["name"])
	fmt.Println(rstMap["age"])
}
