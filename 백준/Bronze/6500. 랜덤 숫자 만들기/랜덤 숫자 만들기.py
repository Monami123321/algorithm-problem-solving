import sys

ans = []
for l in map(int, sys.stdin.read().rstrip().split("\n")):
    s = {l}
    while True:        
        n = str(l * l)
        l = int(("0" * (8 - len(n)) + n)[2:6])
        if l in s:
            break
        s.add(l)
    ans.append(str(len(s)))
ans.pop()
sys.stdout.write("\n".join(ans))           