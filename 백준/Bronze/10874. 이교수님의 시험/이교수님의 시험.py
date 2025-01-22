import sys

ans_list = [(x - 1) % 5 + 1 for x in range(1, 11)]
n = int(sys.stdin.readline())
ans = []
for i in range(1, n+1):
    flag = True
    for j, v in enumerate(map(int, sys.stdin.readline().split())):
        if ans_list[j] != v:
            flag = False
            break
    if flag:
        ans.append(str(i))
sys.stdout.write("\n".join(ans))        
        
            
        
        