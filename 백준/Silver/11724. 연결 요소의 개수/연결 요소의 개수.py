import sys

def find_set(a):
    if parent[a] != a:
        parent[a] = find_set(parent[a])
    return parent[a]       

def union(a, b):
    parent_a = parent[a]
    parent_b = parent[b]
    if parent_a == parent_b:
        return
    if parent_a < parent_b:
        parent[parent_b] = parent_a
    else:
        parent[parent_a] = parent_b      
        
n, m = map(int, sys.stdin.readline().split())
parent = [x for x in range(n + 1)]
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    union(a, b)
visited = [False] * (n + 1)
ans = 0
for i in range(1, n+1):
    a = find_set(parent[i])
    if not visited[a]:
        ans += 1
        visited[a] = True

sys.stdout.write(str(ans))         