import sys
tc = int(sys.stdin.readline().strip())
while tc:
    tc -= 1
    a, b = map(int, sys.stdin.readline().strip().split())
    sys.stdout.write(str((a + b) * (a + b) * (a + b - 1) >> 1) + "\n")
