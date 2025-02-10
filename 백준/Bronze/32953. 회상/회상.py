import sys
n, m = map(int, sys.stdin.readline().split())
hm = {}
for i in range(n):
    sys.stdin.readline()
    for l in sys.stdin.readline().rstrip().split():
        hm[l] = hm.get(l, 0) + 1
ans = 0
for i in hm.values():
    if i >= m:
        ans += 1
    
sys.stdout.write(str(ans))                   