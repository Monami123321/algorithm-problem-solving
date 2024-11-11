import sys
ans = []
for i in range(int(sys.stdin.read()), 0, -1):
    ans.append("*" * i)
sys.stdout.write("\n".join(ans))    
    