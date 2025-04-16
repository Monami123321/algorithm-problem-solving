import sys

sys.setrecursionlimit(100001)
n, m, r = map(int, sys.stdin.readline().split())
adj_list = [[] for i in range(n + 1)] 
visited = [False] * (n + 1)
ans = [0] * n
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    adj_list[a].append(b)
    adj_list[b].append(a)
for i in range(1, n + 1):
    adj_list[i].sort(reverse=True) 
depth = 1    
def dfs(node, visited, ans):
    global depth
    visited[node] = True
    ans[node - 1] = depth
    depth += 1
    for i in adj_list[node]:
        if not visited[i]:
            dfs(i, visited, ans)
dfs(r, visited, ans)            
sys.stdout.write("\n".join(map(lambda x: str(x[1]) if visited[x[0] + 1] else "0", enumerate(ans)))) 