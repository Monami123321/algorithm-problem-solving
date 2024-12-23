import sys
tc, *line = sys.stdin.read().rstrip().split("\n")
ans = []
for l in line:
    val, *cmd = l.split()
    val = float(val)
    for c in cmd:
        if c == '@':
            val *= 3
        elif c == '%':
            val += 5
        else:
            val -= 7
    ans.append(format(val,".2f"))
sys.stdout.write("\n".join(ans))        