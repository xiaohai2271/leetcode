package main

import (
	"fmt"
	"testing"
)

func Test_maxProfit(t *testing.T) {
	type args struct {
		inventory []int
		orders    int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"", args{[]int{6, 10, 10}, 12}, 91},
		{"", args{[]int{2, 5}, 4}, 14},
		{"", args{[]int{3, 5}, 6}, 19},
		{"", args{[]int{2, 8, 4, 10, 6}, 20}, 110},
		{"", args{[]int{10000}, 10000}, 50005000},
		{"", args{[]int{1000000000}, 1000000000}, 21},
		// [9] 3   9+8+7
		// 520895776 ~ 773160767		520,895,777 +....+ 773160767
		{"", args{[]int{773160767}, 252264991}, 70267492},
		{"", args{[]int{497978859, 167261111, 483575207, 591815159}, 836556809}, 373219333},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			fmt.Println(tt.args)
			if got := maxProfit(tt.args.inventory, tt.args.orders); got != tt.want {
				t.Errorf("maxProfit() = %v, want %v", got, tt.want)
			}
		})
	}
}
