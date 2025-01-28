import sys

n, x = map(int, sys.stdin.readline().split())
ans = -1
for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    if a + b > x:
        continue
    ans = max(ans, a)        
sys.stdout.write(str(ans))            