import sys

n, e, *lst, v1, v2 = map(int, sys.stdin.read().rstrip().split())
INF = 1 << 29
dist = [[INF for __ in range(n + 1)] for _ in range(n + 1)]
for i in range(n + 1):
    dist[i][i] = 0

for i in range(0, e * 3, 3):
    a, b, c = lst[i], lst[i + 1], lst[i + 2]
    dist[a][b] = dist[b][a] = c

for i in range(n + 1):
    for j in range(n + 1):
        for k in range(n + 1):
            if dist[j][k] > dist[j][i] + dist[i][k]:
                dist[j][k] = dist[j][i] + dist[i][k]
ans = min(dist[1][v1] + dist[v1][v2] + dist[v2][n], dist[1][v2] + dist[v2][v1] + dist[v1][n])
sys.stdout.write(str(-1 if ans >= INF else ans))