import sys
t, x, m = map(int, sys.stdin.readline().split())
n = 1 << 29
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    n = min(n, (a - 1) // b)
if n == 0:
    sys.stdout.write("0")
    exit()
ans = min(n, t)
t -= min(t, n)
ans += t >> 1
sys.stdout.write(str(ans * x))
