import sys
a, b, c = sorted(map(int, sys.stdin.read().split()))
sys.stdout.write(str(max(b - a, c - b) - 1))