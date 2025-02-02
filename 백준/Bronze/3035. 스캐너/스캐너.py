import sys
r, c, zr, zc = map(int, sys.stdin.readline().split())
ans = []
lst = sys.stdin.read().rstrip().split("\n")
for i in range(r):
    tmp = ""
    for j in range(c):
        tmp += lst[i][j] * zc
    for j in range(zr):
        ans.append(tmp)
sys.stdout.write("\n".join(ans))            
        