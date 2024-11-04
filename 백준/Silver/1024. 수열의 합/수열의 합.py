import sys
n, l = map(int, sys.stdin.read().split(" "))

for i in range(l, 101):
    m = (i * (i - 1)) >> 1
    if m > n:
        break
    if (n - m) % i == 0 :
        s = (n - m) // i
        sys.stdout.write(" ".join([str(j) for j in range(s, s + i)]))
        exit()
        
sys.stdout.write("-1")       
    
    