import sys

def get_xor(n):
    if n % 4 == 0:
        return n
    if n % 4 == 1:
        return 1
    if n % 4 == 2:
        return n + 1
    return 0

ans = []
tc = int(sys.stdin.readline())
for i in range(tc):
    s, e = map(int, sys.stdin.readline().split())
    ans.append(str(get_xor(s-1) ^ get_xor(e)))
sys.stdout.write("\n".join(ans))
    