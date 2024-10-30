import sys
a, b = map(int, sys.stdin.read().split())
n = a
s = [a]
visited = [False] * 1001
while not visited[(a := n * a % b)]:
        visited[a] = True
        s.append(a)
sys.stdout.write(str(len(s) - s.index(a)))