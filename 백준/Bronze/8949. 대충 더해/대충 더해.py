import sys
a, b = map(lambda x: list(map(int, x)), sys.stdin.read().split())
size = max(len(a), len(b))
if len(a) < size:
    for i in range(size - len(a)):
        a.insert(0, 0)
if len(b) < size:
    for i in range(size - len(b)):
        b.insert(0, 0)        
ans = []        
for i in range(size):
    ans.append(str(int(a[i]) + int(b[i])))
sys.stdout.write("".join(ans))    
    