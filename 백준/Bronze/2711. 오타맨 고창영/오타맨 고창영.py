import sys
tc, *line = sys.stdin.read().rstrip().split("\n")
ans = []
for l in line:
    index, tmp = l.split()
    tmp = list(tmp)
    tmp.pop(int(index) - 1)
    ans.append("".join(tmp))
sys.stdout.write("\n".join(ans))    