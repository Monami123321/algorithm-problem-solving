import sys

sys.setrecursionlimit(100000)

n = int(sys.stdin.readline())
adj_lst = [[] for _ in range(n + 1)]
parent = [0] * (n + 1)
visited = [False] * (n + 1)

for line in sys.stdin.read().rstrip().split("\n"):
    a, b = map(int, line.split(" "))
    adj_lst[a].append(b)
    adj_lst[b].append(a)


def dfs(node):
    global adj_lst, parent, visited
    if visited[node]:
        return
    visited[node] = True
    for c in adj_lst[node]:
        if visited[c]:
            continue
        parent[c] = node
        dfs(c)


dfs(1)
ans = []
for i in range(2, n + 1):
    ans.append(str(parent[i]))
sys.stdout.write("\n".join(ans))
