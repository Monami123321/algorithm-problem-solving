import sys
a, b, c, d = map(int, sys.stdin.read().split())
sys.stdout.write(str(a * b + c * d))