import sys
a, b = map(int, sys.stdin.read().split())
if b < a:
    a ^= b 
    b ^= a 
    a ^= b
l = b - a + 1
sys.stdout.write(str((l * (l + 1) >> 1) + l * (a - 1)))