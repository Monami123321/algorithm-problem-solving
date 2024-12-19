import sys, collections

dq = collections.deque()
input = sys.stdin.readline
n = int(input())
a, b = map(int, input().split())
m = int(input())
adjList = [[] for x in range(n + 1)]
for i in range(m):
    s, e = map(int, input().split())
    adjList[s].append(e)
    adjList[e].append(s)
visited = [False] * (n + 1)    
dq.append((a, 0))    
visited[a] = True
ans = -1
while dq:
    node, t = dq.popleft()
    if node == b:
        ans = t
        break
    for i in adjList[node]:
        if not visited[i]:
            visited[i] = True
            dq.append((i, t+1))
sys.stdout.write(str(ans))