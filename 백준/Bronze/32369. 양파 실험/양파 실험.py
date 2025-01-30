import sys
n, a, b = map(int, sys.stdin.read().split())

o_g, o_b = 1, 1
while n:
    n -= 1
    o_g += a
    o_b += b
    if o_b > o_g:
        o_g, o_b = o_b, o_g
    elif o_b == o_g:
        o_b -= 1
sys.stdout.write(f"{o_g} {o_b}")        


