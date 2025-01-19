import sys
lst = [1, 1, 2, 2, 2, 8]
for i, v in enumerate(map(int, sys.stdin.read().rstrip().split())):
    lst[i] -= v
sys.stdout.write(" ".join(map(str,lst)))    
    