package testbasic

import (
	"fmt"
	"gop/com/zhonghuasheng/tools"
	"testing"
)

func TestContainsAny2(t *testing.T) {
	s1 := []any{"a", "b", "v"}
	s2 := []any{1, 2, 3}
	r1 := tools.Contains(s1, "a")
	r2 := tools.Contains(s1, "ac")
	r3 := tools.Contains(s2, "a")
	r4 := tools.Contains(s1, 1)
	fmt.Println(r1, r2, r3, r4)
}
