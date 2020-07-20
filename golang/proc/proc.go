package main

import (
	"fmt"
	"os"
	"os/exec"
)

func main() {

	// get `go` executable path
	goExecutable, _ := exec.LookPath("python")

	// construct `go version` command
	cmdGoVer := &exec.Cmd{
		Path:   goExecutable,
		Args:   []string{goExecutable, "-m", "SimpleHTTPServer", "9000"},
		Stdout: os.Stdout,
		Stderr: os.Stdout,
	}

	// run `go version` command
	if err := cmdGoVer.Start(); err != nil {
		fmt.Println("Error:", err)
	}

}
