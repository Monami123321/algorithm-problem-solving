import sys
n, k, *lst = map(int, sys.stdin.read().split())
for i in range(1, n):
    lst[i] += lst[i - 1]
sys.stdout.write(str(sum(sorted(lst, reverse=True)[:k])))
    
    
    