import sys

n, *lst = map(int, sys.stdin.read().split())
for i, x in enumerate(lst):
    lst[i] = [i + 1, x]
ans = []    
index = 0
size = 0
while True:
    ans.append(str(lst[index][0]))
    m = lst[index][1] - 1 if lst[index][1] > 0 else lst[index][1]
    del lst[index]        
    if (size := len(lst)) == 0:
            break              
    index = (index + m + size) % size
sys.stdout.write(" ".join(ans))    
    
    



