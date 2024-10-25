import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.read().rstrip().split("\n")))
ref = 0
cnt = 0
for i in reversed(arr):
    if i > ref:
        ref = i
        cnt += 1
sys.stdout.write(str(cnt))
