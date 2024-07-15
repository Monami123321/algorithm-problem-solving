n = int(input())
arr = []
cntL = 0
cntR = 0
now = 0
for i in range(n):
    arr.append(int(input()))
    if arr[i] > now:
        cntL += 1
        now = arr[i]
now = 0
for i in range(n - 1, -1, -1):
    if arr[i] > now:
        cntR += 1
        now = arr[i]
                
print(cntL)
print(cntR)

  
    