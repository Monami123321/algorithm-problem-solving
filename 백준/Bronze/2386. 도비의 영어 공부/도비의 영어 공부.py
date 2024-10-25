import sys

for l in sys.stdin.read().rstrip().split("\n"):
    if l == "#":
        break
    a = l[0]
    l = l[2:].lower()
    cnt = 0
    for ll in l:
        if ll == a:
            cnt += 1
    
    sys.stdout.write(f"{a} {cnt}\n")
        
    
    

        
    
    
    
