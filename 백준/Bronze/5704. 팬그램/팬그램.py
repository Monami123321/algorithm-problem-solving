import sys

ans = []
for line in sys.stdin.read().rstrip("*\n").split("\n"):
    visited = [False] * 128
    for l in line:
        visited[ord(l)] = True
    flag = True        
    for i in range(97, 123):
        if not visited[i]:
            ans.append("N")
            flag = False
            break
    if flag:
        ans.append("Y")
sys.stdout.write("\n".join(ans))                    
        
    