import sys
n, a, b = sys.stdin.read().rstrip().split("\n")
n = int(n) & 1
flag = True
if n == 0:
    flag = a == b
else:
    for i in range(len(a)):
        if a[i] == b[i]:
            flag = False
            break
sys.stdout.write("Deletion succeeded" if flag else "Deletion failed")            
            
