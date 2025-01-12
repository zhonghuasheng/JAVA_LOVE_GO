package slice

import (
	"fmt"
	"reflect"
	"testing"
)

// 验证数组值传递时存在的陷阱
func TestAppend(t *testing.T) {
	arr := []int{1, 2}
	add(arr)
	arr[1] = 20
	fmt.Println(arr)
}

func add(arr []int) {
	for i := 3; i < 10; i++ {
		arr = append(arr, i)
	}
	arr[0] = 10
	fmt.Println(arr)
}

func TestChangeSlice(t *testing.T) {
	s := make([]int, 10, 12)
	t.Logf("s:%v", s)
	s1 := s[8:] // 引用传递
	t1 := reflect.TypeOf(s1)
	t.Logf("s1 type:%v", t1)
	changeSlice1(s1)
	t.Logf("changeSlice1 s1 %v", s1)
	t.Logf("changeSlice1 s %v", s)
	changeSlice2(s1)
	t.Logf("changeSlice2 s1:%v", s1)
	t.Logf("changeSlice2 s:%v", s)
}

// 未发生扩容，s1的值中的sliceHeader对应的data的地址与s中index=8的位置的数据地址是同一个
func changeSlice1(s1 []int) {
	s1[0] = -1
}

// 这里进行了s1的值传递，但是s1的值中的sliceHeader对应的data的地址与s中index=8的位置的数据地址是同一个
// 发生扩容后，s1的地址发生了变化，重新申请了一块独立的空间
func changeSlice2(s1 []int) {
	for i := 1; i < 20; i++ {
		s1 = append(s1, i)
	}
	s1[0] = -10
	fmt.Printf("append s1 %v\n", s1)
}
