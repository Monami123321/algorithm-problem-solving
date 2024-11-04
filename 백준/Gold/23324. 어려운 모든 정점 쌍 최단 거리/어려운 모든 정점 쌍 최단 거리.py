import sys, collections

n, m, k = map(int, sys.stdin.readline().split())
adjList = [[] for _ in range(n + 1)]
for i, l in enumerate(sys.stdin.read().rstrip().split("\n"), 1):
    a, b = map(int, l.split())
    if i == k:
        continue
    adjList[a].append(b)
    adjList[b].append(a)

q = collections.deque([1])
visited = {1}
cnt = 0
while q:
    node = q.pop()
    cnt += 1
    for e in adjList[node]:
        if e not in visited:
            visited.add(e)
            q.append(e)
sys.stdout.write(str(cnt * (n - cnt)))
