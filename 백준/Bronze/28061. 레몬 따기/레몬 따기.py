import sys
n, lst = sys.stdin.read().rstrip().split("\n")
n = int(n)
cnt = 0
for i, m in enumerate(map(int, lst.split(" "))):
    cnt = max(cnt, m - (n - i))
sys.stdout.write(str(cnt))
    
    
