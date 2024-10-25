import sys
tc = int(sys.stdin.readline())
while tc:
    tc -= 1
    a, b = map(int, sys.stdin.readline().split())
    sys.stdout.write(str(a + b) + "\n")