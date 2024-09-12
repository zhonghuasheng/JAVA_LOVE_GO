package tools

// Contains 判断目标x是否在数据s中
func Contains(s []any, x any) bool {
	for _, i := range s {
		if i == x {
			return true
		}
	}
	return false
}
