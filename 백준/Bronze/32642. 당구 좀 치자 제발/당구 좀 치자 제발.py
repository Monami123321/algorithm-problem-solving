import sys

ans = 0
n = 0
lst = list(map(lambda x: True if x == "1" else False, sys.stdin.read().rstrip().split()))
for i in range(1, len(lst)):
    if lst[i]:
        n += 1
    else:
        n -= 1
    ans += n
sys.stdout.write(str(ans))    