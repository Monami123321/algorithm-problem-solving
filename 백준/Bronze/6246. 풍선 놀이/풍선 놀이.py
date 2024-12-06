import sys

n, q = map(int, sys.stdin.readline().split())
lst = [True] * n
for _ in range(q):
    s, d = map(int, sys.stdin.readline().split())
    for i in range(s - 1, n, d):
        lst[i] = False
sys.stdout.write(str(sum(1 for x in lst if x)))      