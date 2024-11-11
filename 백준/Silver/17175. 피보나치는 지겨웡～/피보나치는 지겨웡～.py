import sys
MOD = 1000000007 
n = int(sys.stdin.read())
lst = [1, 1, 3]
for i in range(2, n):
    lst.append((1 + lst[i] + lst[i - 1]) % MOD)
sys.stdout.write(str(lst[n]))    
    

