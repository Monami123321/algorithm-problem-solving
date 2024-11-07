import sys
n, *arr = sys.stdin.read().rstrip().split("\n")
for i, l in enumerate(arr):
    arr[i] = l.rstrip()
n = int(n)
size = len(arr[0])
ans = []

for i in range(size):
    flag = False
    for j in range(1, n):
        if arr[j][i] != arr[j - 1][i]:
            ans.append("?")
            flag = True
            break
    if flag:
        continue
    ans.append(arr[0][i])            
sys.stdout.write("".join(ans))        