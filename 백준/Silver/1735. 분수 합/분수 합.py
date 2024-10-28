import sys

def get_gcd(a, b):
    while b:
        tmp = a % b
        a = b
        b = tmp
    return a        

a, b = map(int, sys.stdin.readline().split())
c, d = map(int, sys.stdin.readline().split())

num = a * d + b * c
div = b * d
gcd = get_gcd(num, div)
sys.stdout.write(f"{num // gcd} {div // gcd}")