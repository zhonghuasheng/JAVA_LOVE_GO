package getstartedtest

import (
	"fmt"
	"testing"

	"github.com/antonmedv/expr"
)

func TestGoTypes(t *testing.T) {
	env := map[string]interface{}{
		"greet":   "Hello, %v!",
		"names":   []string{"world", "you"},
		"sprintf": fmt.Sprintf,
	}
	code := `sprintf(greet, names[0])`
	// Compile code into bytecode. This step can be done once and program may be reused.
	// Specify environment for type check.
	program, err := expr.Compile(code, expr.Env(env))
	if err != nil {
		panic(err)
	}
	output, err := expr.Run(program, env)
	if err != nil {
		panic(err)
	}
	fmt.Print(output)
}
