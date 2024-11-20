import sys
input = sys.stdin.readline
t, x, m = map(int, input().split())
n = 1 << 29
for i in range(m):
    a, b = map(int, input().split())
    n = min(n, (a - 1) // b)
    if n == 0:
        sys.stdout.write(str("0"))
        exit()        
ans = min(n, t)
t -= min(t, n)
ans += t >> 1
sys.stdout.write(str(ans * x))
