import sys

n, *arr = map(int, sys.stdin.read().rstrip().split())
arr.sort()
cnt = 0
for i in range(1, n):
    cnt += arr[i] - arr[i - 1]
sys.stdout.write(str(cnt + arr[-1] - arr[0]))