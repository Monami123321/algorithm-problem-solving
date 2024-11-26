import sys
tc, *line = sys.stdin.read().rstrip().split("\n")
ans = []
for l in line:
    ans.append(l[::-1])
sys.stdout.write("\n".join(ans))    