import sys

ans = []
for line in sys.stdin.read().rstrip().split("\n"):
    cnt = 1
    for l in line:
        cnt += 1
        if l == "1":
            cnt += 2
        elif l == "0":
            cnt += 4
        else:
            cnt += 3
    ans.append(str(cnt))
ans.pop()
sys.stdout.write("\n".join(ans))    
    
        
    