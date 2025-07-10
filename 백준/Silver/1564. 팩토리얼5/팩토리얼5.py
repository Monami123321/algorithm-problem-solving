import sys

def cnt_five(n):
    cnt = 0
    while True:
        if n % 5 == 0:
            cnt += 1
            n //= 5
        else:
            return cnt

n = int(sys.stdin.readline())
MOD = 10000000000000
ans = 1
for i in range(2, n + 1):
    cnt = cnt_five(i)
    ans *= i
    if cnt:
        ans //= 10**cnt
    ans %= MOD
print(str(ans)[-5:])



