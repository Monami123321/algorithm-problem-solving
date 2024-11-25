import sys
ans = []
for i in sys.stdin.read().split("-"):
    ans.append(i[0])
sys.stdout.write("".join(ans))    