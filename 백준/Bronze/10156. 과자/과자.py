import sys
a,b,c = map(int, sys.stdin.read().split())
sys.stdout.write(str(max(0, a * b - c)))