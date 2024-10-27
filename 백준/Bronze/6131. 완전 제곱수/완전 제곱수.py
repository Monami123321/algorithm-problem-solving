import sys

n = int(sys.stdin.read())
def isValid(a, b, n):
    return a ** 2 - b ** 2 == n

cnt = 0
for a in range(1, 501):
    for b in range(1, a):
        if isValid(a, b, n):
            cnt += 1
sys.stdout.write(str(cnt))
          
        
        