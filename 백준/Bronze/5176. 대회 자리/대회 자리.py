import sys
tc = int(sys.stdin.readline())
ans = []
while tc:
    tc -=1
    n, m = map(int, sys.stdin.readline().split())
    visited = [False] * (m + 1)
    cnt = 0;
    for i in range(n):
        if visited[(tmp := int(sys.stdin.readline()))]:
            cnt += 1
        else:
            visited[tmp] = True
    ans.append(str(cnt))            
sys.stdout.write("\n".join(ans))    