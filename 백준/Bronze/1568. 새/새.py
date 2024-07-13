n = int(input())
now = 1
t = 0
while n > 0:
    if now > n:
        now = 1
        continue
    t += 1
    n -= now
    now += 1
print(t)
    
    
    
    