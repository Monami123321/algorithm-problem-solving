import sys
ans = []
for line in sys.stdin.read().rstrip().split("\n"):
    m, p, l, e, r, s, n = map(int, line.split())
    while n:
        n -= 1
        m *= e
        l //= r
        p //= s
        m, l, p = p, m, l
    ans.append(str(m))
sys.stdout.write("\n".join(ans))        