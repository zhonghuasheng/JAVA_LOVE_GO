package testhttp

import (
	"fmt"
	"net/http"
	"strings"
	"testing"
)

func TestPort(t *testing.T) {
	r, err := http.NewRequest("GET", "http://test.com", nil)
	if err != nil {
		panic(err)
	}
	r.Host = "test.com"
	s1 := strings.Split(r.Host, ":")
	fmt.Println(len(s1))
	r.Host = "test.com:80"
	s2 := strings.Split(r.Host, ":")
	fmt.Println(len(s2))
}
