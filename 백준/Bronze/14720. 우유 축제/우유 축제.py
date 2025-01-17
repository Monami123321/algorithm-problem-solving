import sys

n, *lst = map(int, sys.stdin.read().split())
now = 0
ans = 0
for i in range(n):
    if lst[i] == now:
        ans += 1
        now = (now + 1) % 3
sys.stdout.write(str(ans))        
    
    
