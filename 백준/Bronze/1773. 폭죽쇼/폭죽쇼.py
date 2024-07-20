from sys import stdin
n, c = map(int,stdin.readline().split())
visited = [False] * (c + 1)
arr = []
for i in range(n):
    t = int(stdin.readline())
    if any(t % x == 0 for x in arr):
        continue
    arr.append(t)
    now = t
    while now <= c:
        visited[now] = True
        now += t
    
ans = 0
for i in range(1, c + 1):
    if visited[i]:
        ans += 1

print(ans)        