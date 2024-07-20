from sys import stdin
def is_contains(num, i):
    while num > 0:
        if num % 10 == i:
            return True
        num //= 10
    return False
n, l = map(int, stdin.read().split())
index = 1
cnt = 0
while cnt < n:
    if is_contains(index, l):
        index += 1
    else:
        index += 1
        cnt += 1

print(index - 1)        
    
    
    
    
    
    