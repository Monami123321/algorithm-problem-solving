import sys
tc = int(sys.stdin.readline())
out = []
while tc:
    tc -= 1
    n = int(sys.stdin.readline())
    d = {}
    offset = []
    for i, v in enumerate(sys.stdin.readline().split()):
        d[v] = i
    for i, v in enumerate(sys.stdin.readline().split()):
        offset.append(d[v] - i)
    ans = [None] * n         
    for i, v in enumerate(sys.stdin.readline().split()):
        ans[offset[i] + i] = v
    out.append(" ".join(ans))                
sys.stdout.write("\n".join(out))          