package getstartedtest

import (
	"fmt"
	"testing"

	"github.com/antonmedv/expr"
)

func TestDefineMethod(t *testing.T) {
	env := map[string]any{
		"foo":    1,
		"double": func(i int) int { return i * 2 },
	}
	program, _ := expr.Compile("double(foo)", expr.Env(env))
	output, _ := expr.Run(program, env)
	fmt.Println(output)
}

func TestDefineMethod2(t *testing.T) {
	env := map[string]any{
		"foo":    "bob",
		"double": GetRst,
	}
	program, _ := expr.Compile("double(foo)", expr.Env(env))
	output, _ := expr.Run(program, env)
	fmt.Println(output)
}

func GetRst(i string) string {
	return "hello bob"
}
