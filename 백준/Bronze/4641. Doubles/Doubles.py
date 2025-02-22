import sys

ans = []
for line in sys.stdin:
    lst = list(map(int, line.split()))
    lst.pop()
    if (l := len(lst)) == 0:
        break
    cnt = 0        
    for i in range(l):
        tmp = lst[i] << 1
        for n in lst:
            if n == tmp:
                cnt += 1
    ans.append(str(cnt))        
sys.stdout.write("\n".join(ans))            
