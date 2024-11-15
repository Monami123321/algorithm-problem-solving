import sys
tc, *lst = map(int, sys.stdin.read().rstrip().split())
index = 0
arr = [[0] * 15 for _ in range(15)]
for i in range(1, 15):
    arr[0][i] = i
    arr[i][1] = 1  
for i in range(1, 15):
    for j in range(2, 15):
        arr[i][j] = arr[i][j-1] + arr[i - 1][j]
ans = []        
for i in range(tc):
    k, n = lst[index:index + 2]
    index += 2
    ans.append(str(arr[k][n]))
sys.stdout.write("\n".join(ans))    
    
