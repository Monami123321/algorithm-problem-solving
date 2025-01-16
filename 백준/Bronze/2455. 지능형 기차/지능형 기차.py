import sys

ans = 0
now = 0
for i in range(4):
    a, b = map(int, sys.stdin.readline().split())
    now = min(10000, now + b - a)
    ans = max(now, ans)
sys.stdout.write(str(ans))
    
    
    
