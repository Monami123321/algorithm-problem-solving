import sys
ans = []
for line in sys.stdin.read().rstrip().split("\n"):
    tmp = 0
    for i, v in enumerate(map(lambda x: 0 if x == ' ' else ord(x) - 64, line), 1):
        tmp += i * v
    ans.append(str(tmp))        
ans.pop()
sys.stdout.write("\n".join(ans))    
    
        
    
    
    