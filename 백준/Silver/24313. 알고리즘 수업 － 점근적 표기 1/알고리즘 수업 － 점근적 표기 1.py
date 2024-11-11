import sys
a,b,c,d = map(int, sys.stdin.read().split())
if a > c or a * d + b > c * d:
    sys.stdout.write("0")
else:
    sys.stdout.write("1")