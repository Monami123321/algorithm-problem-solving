tmp = int(open(0).read())
ans = [str(x) for x in range(1, tmp)]
s = tmp * (tmp - 1) >> 1
last = 1000000000
while True:
    if (s + last) % tmp == 0:
        break
    last -= 1
ans.append(str(last))
ans.append(str((s + last) // tmp))
print(" ".join(ans))    
        
    
    