import sys

n = int(sys.stdin.readline())
lst = sys.stdin.readline().rstrip().split()
s = set(sys.stdin.readline().rstrip().split())
for i in lst:
    if i not in s:
        sys.stdout.write(i)
        break
        
