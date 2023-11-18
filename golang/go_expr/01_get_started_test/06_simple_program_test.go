package getstartedtest

import (
	"fmt"
	"testing"

	"github.com/antonmedv/expr"
)

type Env struct {
	X int
	Y int
}

func TestProgram(t *testing.T) {
	code := `X + Y`
	program, err := expr.Compile(code, expr.Env(Env{}))
	if err != nil {
		panic(err)
	}
	output, err := expr.Run(program, Env{1, 1})
	if err != nil {
		panic(err)
	}
	fmt.Println(output)
	// 多次使用program
	output, _ = expr.Run(program, Env{3, 4})
	fmt.Println(output)
}
