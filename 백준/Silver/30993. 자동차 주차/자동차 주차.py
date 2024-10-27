import sys
arr = [i for i in range(16)]
for i in range(3, 16):
    arr[i] *= arr[i - 1]
n, a, b, c = map(int, sys.stdin.read().split(" "))
sys.stdout.write(str(arr[n] // arr[a] // arr[b] // arr[c]))
