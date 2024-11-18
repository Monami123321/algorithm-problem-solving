import sys
lst = list(map(int, sys.stdin.read().rstrip().split()))
n = len(lst)
ans = []
for i in range(0, n, 2):
    ans.append(str(lst[i + 1] // (lst[i] + 1)))
sys.stdout.write("\n".join(ans))    