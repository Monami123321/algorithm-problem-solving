import sys
tc, *line = map(int, sys.stdin.read().rstrip().split("\n"))
ans = []
for l in line:
    tmp = f"Pairs for {l}: "
    flag = False
    for i in range(1, l // 2 + 1):
        if (i << 1) == l:
            break
        tmp += f"{i} {l - i}, "
        flag = True
    if flag:
        ans.append(tmp[:-2])
    else:
        ans.append(tmp)
sys.stdout.write("\n".join(ans))            
        
        
    
