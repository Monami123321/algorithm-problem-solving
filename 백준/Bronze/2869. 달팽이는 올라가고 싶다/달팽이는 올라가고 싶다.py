import sys
a, b, c = map(int, sys.stdin.read().split())
ans = 0
if (c - b) % (a - b) == 0:
    ans = (c - b) // (a - b)
else:
    ans = (c - b) // (a - b) + 1
sys.stdout.write(str(ans))    
    