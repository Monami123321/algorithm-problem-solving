import math

n = int(input())
lst = list(map(int, input().split()))
m = int(input())
ans = 0
for i in lst:
    ans += math.ceil(i / m) * m
print(ans)