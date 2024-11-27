import sys
tc, *line = sys.stdin.read().rstrip().split("\n")
ans = []
for l in line:
    ans.append(str(len(set([x for x in l]))))
sys.stdout.write("\n".join(ans))    
   
    