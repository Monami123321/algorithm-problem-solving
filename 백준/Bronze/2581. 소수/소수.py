def is_prime(n):
    if n < 2:
        return False
    if n < 4:
        return True
    if (n & 1) == 0 or n % 3 == 0:
        return False
    limit = int(n ** 0.5) + 1
    for i in range(5, limit, 6):
        if n % i == 0 or n % (i + 2) == 0:
            return False
        
    return True

start = int(input())
end = int(input())
sum = 0
prime = 0
for i in range(end, start - 1, -1):
    if is_prime(i):
        sum += i
        prime = i        
        
if sum == 0:
    print(-1)
else:
    print(sum)
    print(prime)
    
    
    
   