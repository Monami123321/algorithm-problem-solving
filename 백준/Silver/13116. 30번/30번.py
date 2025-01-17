from sys import stdin, stdout
from bisect import bisect_left

def up(a, t):
    for i in range(t):
        a = a >> 1        
    return a        
        
lst = [(1 << x) - 1 for x in range(11)]
tc = int(stdin.readline())
ans = []
while tc:
    tc -= 1
    a, b = map(int, stdin.readline().split())
    if(a > b):
        a, b = b, a
    diff = bisect_left(lst, b) - bisect_left(lst, a)        
    ref = b
    b = up(b, diff)
    while a != b:
        a = up(a, 1)
        b = up(b, 1)
        diff += 1
    ans.append(str((ref >> diff) * 10))            
stdout.write("\n".join(ans))        
   
    
        
            