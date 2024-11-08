import sys
tc, *arr = sys.stdin.read().rstrip().split("\n")
ans = []
for line in arr:
    l = len(line.rstrip()) >> 1
    if line[l - 1] == line[l]:
        ans.append("Do-it")
    else:
        ans.append("Do-it-Not")
sys.stdout.write("\n".join(ans))    