import sys

def bin_search(lst, val):
    l = 0
    r = len(lst) - 1
    while l <= r:
        index = (l + r) >> 1
        if lst[index] < val:
            l = index + 1
        else:
            r = index - 1
    return min(len(lst), l)



n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))
lis = [1 << 20 for _ in range(n)]
ans = 1
for i in lst:
    index = bin_search(lis, i)
    ans = max(ans, index + 1)
    lis[index] = i
sys.stdout.write(str(ans))