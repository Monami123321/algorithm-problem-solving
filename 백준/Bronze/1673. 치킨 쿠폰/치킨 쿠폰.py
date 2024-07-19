from sys import stdin
ans = []
for line in stdin.read().splitlines():
    n, k = map(int, line.split())
    i = n
    while n >= k:
        i += n // k
        n = n % k + n // k
        
    ans.append(str(i))
print("\n".join(ans))