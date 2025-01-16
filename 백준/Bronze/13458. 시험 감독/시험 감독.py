import sys, math
n, *lst, b, c = map(int, sys.stdin.read().rstrip().split())
ans = 0
for i in lst:
    ans += 1 + math.ceil(max(0, i - b) / c)
sys.stdout.write(str(ans))    