package getstartedtest

import (
	"fmt"
	"testing"

	"github.com/antonmedv/expr"
)

func TestSimple2(t *testing.T) {
	env := map[string]any{
		"foo": 100,
		"bar": 200,
	}
	program, err := expr.Compile(`foo + bar`, expr.Env(env))
	if err != nil {
		panic(err)
	}
	output, err := expr.Run(program, env)
	if err != nil {
		panic(err)
	}
	fmt.Print(output)
}
