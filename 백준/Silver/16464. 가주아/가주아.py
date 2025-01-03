import sys
tc, *lst = map(int, sys.stdin.read().rstrip().split("\n"))
ans = []
for l in lst:
    if l.bit_count() == 1:
        ans.append("GoHanGang")
    else:
        ans.append("Gazua")
sys.stdout.write("\n".join(ans))