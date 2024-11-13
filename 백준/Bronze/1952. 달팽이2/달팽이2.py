import sys
n, m = map(int, sys.stdin.read().split())
arr =[[0 for _ in range(m)] for _ in range(n)]
dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]
r, c = 0, 0
cnt = -1
dir = 0
while True:
    if arr[r][c] == 1:
        break        
    arr[r][c] = 1        
    nr = r + dr[dir]
    nc = c + dc[dir]
    if nr < 0 or nr > n - 1 or nc < 0 or nc > m - 1 or arr[nr][nc] == 1:
        dir = (dir + 1) % 4
        cnt += 1
    r += dr[dir]
    c += dc[dir]        
sys.stdout.write(str(cnt))        
        
    
    
    
    