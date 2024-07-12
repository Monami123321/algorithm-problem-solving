input()
visited = [False] * 101
n = 0
for i in map(int, input().split()):
    if not visited[i]:
        visited[i] = True
    else:
        n += 1
print(n)        
        
        
