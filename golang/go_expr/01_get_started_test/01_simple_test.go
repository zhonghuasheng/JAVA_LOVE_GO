package getstartedtest

import (
	"fmt"
	"github.com/antonmedv/expr"
	"testing"
)

func TestSimple1(t *testing.T) {
	program, err := expr.Compile(`2+2`)
	if err != nil {
		panic(err)
	}
	output, err := expr.Run(program, nil)
	if err != nil {
		panic(err)
	}
	fmt.Println(output)
}
