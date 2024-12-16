import sys, functools
n, *line = sys.stdin.read().rstrip().split("\n")
ans = []
for l in line:
    tmp = functools.reduce(lambda acc, cur: acc if cur == ' ' else acc + ord(cur) - 64, l, 0)
    ans.append("PERFECT LIFE" if tmp == 100 else str(tmp))
sys.stdout.write("\n".join(ans))    