import sys

tc = int(sys.stdin.readline())
ans = []
while tc:
    tc -= 1
    n, m, k = map(int, sys.stdin.readline().split())
    s = [x for x in range(1, 31) if x % k != m]
    dp = [0] * (n + 1)
    dp[0] = 1
    for i in range(1, n+1):
        for num in s:
            if i - num >= 0:
                dp[i] += dp[i - num]
    ans.append(str(dp[n]))            
sys.stdout.write("\n".join(ans))    