import sys
tc = int(sys.stdin.readline())
ans = []
while tc:
    tc -=1
    n = int(sys.stdin.readline())
    lst = sorted(map(int, sys.stdin.readline().split()))
    ans.append(str(lst[-1] - lst[0] << 1))
sys.stdout.write("\n".join(ans))    