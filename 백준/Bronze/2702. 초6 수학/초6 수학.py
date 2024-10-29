import sys

def get_gcd(a, b):
    while b:
        tmp = a % b
        a = b
        b = tmp
    return a        
    
tc, *lst = sys.stdin.read().rstrip().split("\n")
ans = []
for l in lst:
    a, b = map(int, l.split(" "))
    gcd = get_gcd(a, b)
    ans.append(f"{a * b // gcd} {gcd}")
sys.stdout.write("\n".join(ans))
    