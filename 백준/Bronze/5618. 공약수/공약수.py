import sys, functools, math
def get_gcd(a, b):
    while(b):
        tmp = a % b
        a = b
        b = tmp
    return a        
n, *lst = map(int, sys.stdin.read().split())
gcd = functools.reduce(lambda a, b: get_gcd(a, b), lst)
ans = set()
for i in range(1, int(math.sqrt(gcd)) + 1):
    if gcd % i == 0:
        ans.add(i)
        ans.add(gcd // i)
sys.stdout.write("\n".join(map(str, sorted(ans))))