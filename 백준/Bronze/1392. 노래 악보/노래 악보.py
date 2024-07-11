from bisect import *

n, q = map(int, input().split())
arr = []
for i in range(n):
    arr.append(int(input()))
for i in range(1, len(arr)):
    arr[i] += arr[i-1]
    
ans = []
for i in range(q):
    t = int(input())
    index = bisect_left(arr, t)
    if arr[index] == t:
        ans.append(str(index + 2))
    else:
        ans.append(str(index + 1))
print("\n".join(ans))
    
    
    
    
