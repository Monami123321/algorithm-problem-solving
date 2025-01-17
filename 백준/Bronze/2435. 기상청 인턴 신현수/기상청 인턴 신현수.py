from sys import stdin, stdout

n, l, *lst = map(int, stdin.read().split())
lst.insert(0, 0)

for i in range(1, n + 1):
    lst[i] += lst[i - 1]
ans = -1000000000000   
for i in range(n, l - 1, -1):
    ans = max(ans, lst[i] - lst[i - l])
stdout.write(str(ans))    
    


