n = int(input())
cnt = 1
val = 9
now = 0
ans = 0
while now + val < n:
    now += val
    ans += cnt * val
    cnt += 1
    val *= 10
print(ans + (n - now) *  cnt)    