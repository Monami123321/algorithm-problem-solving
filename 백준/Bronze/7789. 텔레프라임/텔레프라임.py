import sys

def is_prime(n):
    if n < 2:
        return False
    if n < 4:
        return True
    if (n & 1) == 0 or n % 3 == 0:
        return False
    limit = int(n**0.5) + 1
    for i in range(5, limit, 6):
        if n % i == 0 or n % (i + 2) == 0:
            return False
    return True        

a, b = sys.stdin.read().split()
b = int(b + a)
a = int(a)
sys.stdout.write("Yes" if is_prime(a) and is_prime(b) else "No")