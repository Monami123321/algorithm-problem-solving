a, b, c = map(int, input().split())
visited = [0] * (a + b + c + 1)
for i in range(1, a + 1):
    for j in range(1, b + 1):
        for k in range(1, c + 1):
            visited[i + j + k] += 1
max = 0
ans = 0
for index, val in enumerate(visited):
    if val > max:
        max = val
        ans = index
        
print(ans)    
       

