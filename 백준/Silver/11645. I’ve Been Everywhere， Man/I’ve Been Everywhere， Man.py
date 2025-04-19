import sys
tc = int(sys.stdin.readline())
while tc:
    tc -= 1
    n = int(sys.stdin.readline())
    s = set()
    for i in range(n):
        s.add(sys.stdin.readline())
    print(len(s)) 