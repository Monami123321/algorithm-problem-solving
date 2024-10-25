import sys

a, b, c = map(int, sys.stdin.read().rstrip().split("\n"))
sys.stdout.write("1" if a + b <= c else "0")