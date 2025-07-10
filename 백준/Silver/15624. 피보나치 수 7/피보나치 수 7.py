import sys

n = int(sys.stdin.readline())
MOD = 1000000007
a = 0
b = 1
for i in range(n - 1):
    c = (a + b) % MOD
    a = b
    b = c
if n == 0:
    print(0)
else:
    print(b)
    


    
    