import sys
month = [0,31,28,31,30,31,30,31,31,30,31,30,31]
for i in range(1, 13):
    month[i] += month[i - 1]
day = ["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"]
a, b = map(int, sys.stdin.read().split())
sys.stdout.write(day[(month[(b - 1)] + a + 2) % 7])