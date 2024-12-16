import sys
ans = []
for line in sys.stdin.read().rstrip().split("\n"):
    n, b, m = map(float, line.split())
    b /= 100
    cnt = 0
    while n < m:
        cnt += 1
        n *= 1 + b
    ans.append(str(cnt))
sys.stdout.write("\n".join(ans))    