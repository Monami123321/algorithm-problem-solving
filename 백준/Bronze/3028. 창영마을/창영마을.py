import sys

a, b, c = 1, 0, 0

for l in sys.stdin.read().rstrip():
    if l == "A":
        a, b = b, a
    elif l == "B":
        b, c = c, b
    else:
        a, c = c, a
sys.stdout.write(str(1 if a == 1 else 2 if b == 1 else 3))        
        
            
    