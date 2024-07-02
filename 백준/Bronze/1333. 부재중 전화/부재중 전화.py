n, l, d = map(int, input().split())
now = d
ans = 0
limit = (l + 5) * n - 5
while True:
    if(now >= limit):
        ans = now
        break
    tmp = now % (l + 5)
    if tmp >= l:
        ans = now
        break
    now += d
print(ans)
