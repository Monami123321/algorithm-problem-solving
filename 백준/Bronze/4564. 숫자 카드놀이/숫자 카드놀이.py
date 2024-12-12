import sys, functools
ans = []
for line in sys.stdin.read().rstrip().split("\n"):
    tmp = []
    while len(line) > 1:
        tmp.append(line)
        line = str(functools.reduce(lambda acc, cur: acc * cur, map(int, line), 1))
    tmp.append(line)
    ans.append(" ".join(tmp))
ans.pop()    
sys.stdout.write("\n".join(ans))