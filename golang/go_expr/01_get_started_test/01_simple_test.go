package getstartedtest

import (
	"fmt"
	"testing"
	"time"

	"github.com/antonmedv/expr"
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

func TestTime(t *testing.T) {
	timeStr := "2024-04-08T10:53:04.810343499+08:00"
	layout := "2006-01-02T15:04:05.999999999-07:00"

	t2, err := time.Parse(layout, timeStr)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(t2.Format("2006-01-02 15:04:05"))
}
