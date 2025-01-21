import sys

a, b, c = sys.stdin.read().rstrip().split("\n")
sys.stdout.write("NO" if a.find(c) == -1 or b.find(c) == -1 else "YES")
