import sys
tc = int(sys.stdin.readline())
ans = []
while tc:
    tc -= 1
    lst = sorted(map(int, sys.stdin.readline().split()))[1:-1]
    if lst[-1] - lst[0] >= 4:
        ans.append("KIN")
    else:
        ans.append(str(sum(lst)))
sys.stdout.write('\n'.join(ans))        
    