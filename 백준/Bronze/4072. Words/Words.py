import sys
ans = []
for line in sys.stdin.read().rstrip().split("\n"):
    ans.append(" ".join([x[::-1] for x in line.split(" ")]))
ans.pop()
sys.stdout.write("\n".join(ans))