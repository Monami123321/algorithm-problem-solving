import sys
tc, *line = sys.stdin.read().rstrip().split("\n")
ans = []
for l in line:
    a, b, *lst = l.split()
    lst.append(a)
    lst.append(b)
    ans.append(" ".join(lst))
sys.stdout.write("\n".join(ans))    