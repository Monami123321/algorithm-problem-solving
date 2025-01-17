import sys

tc, *lst = map(int, sys.stdin.read().split())
ans = []
for n in lst:
    n = n * (n + 1) >> 1
    m = int(n**0.5)
    while m * (m + 1) <= n:
        m += 1 
    ans.append(str(m))
sys.stdout.write("\n".join(ans))    