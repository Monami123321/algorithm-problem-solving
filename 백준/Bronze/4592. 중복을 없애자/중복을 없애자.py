import sys
ans = []
for line in sys.stdin.read().rstrip().split("\n"):
    n, *lst = map(int, line.split())
    if n == 0:
        break
    tmp = []
    prev = -1
    for i in lst:
        if i == prev:
            continue
        tmp.append(str(i))
        prev = i
    tmp.append("$")
    ans.append(" ".join(tmp))
sys.stdout.write("\n".join(ans))    
    