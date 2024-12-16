import sys
ans = []
s = {'b','d','p','q','i','o','v','w','x'}
trans = str.maketrans("bpdq","dqbp")
for line in sys.stdin.read().rstrip("\n#").split("\n"):
    flag = True
    for i in line:
        if i not in s:
            ans.append("INVALID")
            flag = False
            break
    if flag:            
        ans.append(line[::-1].translate(trans))
sys.stdout.write("\n".join(ans))        
            
    
    