package getstartedtest

import (
	"fmt"
	"testing"
	"time"

	"github.com/antonmedv/expr"
)

type Post struct {
	Body string
	Date time.Time
}

type EnvA struct {
	Posts []Post
}

func (EnvA) Format(t time.Time) string {
	return t.Format(time.RFC822)
}

func TestStruct(t *testing.T) {
	ps := []Post{
		{
			"test1",
			time.Now(),
		},
		{
			"test2",
			time.Now(),
		},
	}
	env := EnvA{
		ps,
	}
	code := `map(Posts, Format(.Date) + ":" + .Body)`
	program, err := expr.Compile(code, expr.Env(EnvA{}))

	if err != nil {
		panic(err)
	}
	output, err := expr.Run(program, env)
	if err != nil {
		panic(err)
	}
	fmt.Print(output)
}
