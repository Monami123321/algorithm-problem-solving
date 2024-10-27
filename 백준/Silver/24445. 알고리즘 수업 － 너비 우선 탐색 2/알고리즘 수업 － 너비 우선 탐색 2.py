import sys
from collections import deque

n, m, start = map(int, sys.stdin.readline().split(" "))
adjList = [[] for i in range(n + 1)]
visited = [False] * (n + 1)
for line in sys.stdin.read().rstrip().split("\n"):
    a, b = map(int, line.split(" "))
    adjList[a].append(b)
    adjList[b].append(a)
for item in adjList:
    item.sort(reverse=True)
q = deque()
visited[start] = True
q.append(start)
ans = ["0"] * n
cnt = 1
while q:
    now = q.popleft()
    ans[now - 1] = str(cnt)
    cnt += 1
    for e in adjList[now]:
        if not visited[e]:
            visited[e] = True
            q.append(e)
    
sys.stdout.write("\n".join(ans))