import sys
ans = []
for l in sys.stdin.read().rstrip().split("\n"):
    a, b = map(int, l.split())
    if a == 0: break
    ans.append("Yes" if a > b else "No")
sys.stdout.write("\n".join(ans))    
    
    