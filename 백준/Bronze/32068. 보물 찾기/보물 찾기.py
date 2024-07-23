from sys import stdin

tc = int(stdin.readline())
ans = []
while tc > 0:
    tc -= 1
    l, r, s = map(int, stdin.readline().split())
    ans.append(str(1 + min(s - l << 1,  (r - s << 1) - 1)))

print("\n".join(ans))    
    