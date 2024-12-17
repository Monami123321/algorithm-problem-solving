import sys
a, b, c = map(int, sys.stdin.read().split())
n = a + b
ans = 0
while True:
    q = n // c
    ans += q
    r = n % c
    n = q + r
    if n < c:
        break
sys.stdout.write(str(ans))    