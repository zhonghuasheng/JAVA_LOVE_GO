package getstartedtest

import (
	"fmt"
	"testing"

	"github.com/antonmedv/expr"
)

type User struct {
	Name    string
	Age     int
	Sex     bool
	Address *Address
}

type Address struct {
	Country    string
	Province   string
	City       string
	RegionCode int
}

var users = []User{
	{
		Name: "Bob",
		Age:  18,
		Sex:  true,
		Address: &Address{
			Country:    "China",
			Province:   "HuBei",
			City:       "WuHan",
			RegionCode: 86,
		},
	},
	{
		Name: "Tom",
		Age:  19,
		Sex:  true,
		Address: &Address{
			Country:    "China",
			Province:   "HuBei",
			City:       "WuHan",
			RegionCode: 86,
		},
	},
	{
		Name: "Lily",
		Age:  8,
		Sex:  false,
		Address: &Address{
			Country:    "China",
			Province:   "HuBei",
			City:       "WuHan",
			RegionCode: 86,
		},
	},
}

func TestOptionalChaining(t *testing.T) {
	env := map[string]any{
		"users": users,
	}
	code := `filter(users, .Name == "Bob")`
	program, err := expr.Compile(code, expr.Env(env))
	if err != nil {
		panic(err)
	}
	output, err := expr.Run(program, env)
	if err != nil {
		panic(err)
	}
	fmt.Println(output)
}
