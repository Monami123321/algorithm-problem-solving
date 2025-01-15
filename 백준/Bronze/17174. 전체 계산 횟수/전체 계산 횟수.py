import sys
n, m = map(int, sys.stdin.read().split())
ans = 0
while n:
    ans += n
    n //= m
sys.stdout.write(str(ans))    
    
    