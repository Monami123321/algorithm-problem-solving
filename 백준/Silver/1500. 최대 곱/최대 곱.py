import sys
a, b = map(int, sys.stdin.read().split())
q = a // b
r = a % b
sys.stdout.write(str(q ** (b-r) *  (q + 1) ** r))