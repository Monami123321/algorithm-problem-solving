import sys
k, n = map(int, sys.stdin.readline().split())
lst = sys.stdin.read().rstrip().split()
s = set()
visited = [False] * n
for i in range(n - 1, -1, -1):
    if lst[i] in s:
        visited[i] = True
    else:
        s.add(lst[i])
ans = []
for i in range(n):
    if(len(ans) == k):
        break
    if not visited[i]:
        ans.append(lst[i])
sys.stdout.write("\n".join(ans))        
    
    
    
    