package channel

/**
递归查找名字为query的文件。思路是，如果是文件夹，则起一个协程来便利文件夹下的内容。为避免资源占用，允许最大的工作协程是N个
当收到searchRequest时，就从当前worker中取一个去执行；收到workerDone消息，则将协程回收；foundMatch时，说明查询到了结果
*/

import (
	"fmt"
	"io/ioutil"
	"testing"
	"time"
)

var query = "find_file_test.go"
var matches int
var workerCounter int
var maxWorkerCounter int = 32
var searchRequest = make(chan string)
var workerDone = make(chan bool)
var foundMatch = make(chan bool)
var masterGoroutine bool

func TestFindFiles(t *testing.T) {
	start := time.Now()
	workerCounter = 1
	go search("D:\\workspace\\JAVA_LOVE_GO\\golang\\gop", true)
	waitForWorkers()
	cost := time.Since(start)
	fmt.Println("time cost ", cost)
}

func waitForWorkers() {
	for {
		select {
		case path := <-searchRequest:
			workerCounter++
			//fmt.Println("search ", path)
			go search(path, true)
		case <-workerDone:
			workerCounter--
			if workerCounter == 0 {
				return
			}
		case <-foundMatch:
			matches++
		}
	}
}

func search(path string, masterGoroutine bool) {
	files, err := ioutil.ReadDir(path)
	if err == nil {
		for _, file := range files {
			name := file.Name()
			//fmt.Println(file.IsDir(), name)
			if file.IsDir() {
				if workerCounter < maxWorkerCounter {
					searchRequest <- path + "\\" + name
				}
			}

			if name == query {
				fmt.Println("find ", name)
				foundMatch <- true
			}
		}
		if masterGoroutine {
			workerDone <- true
		}
	}
}
