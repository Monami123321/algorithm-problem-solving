import sys, itertools

n, m = map(int, sys.stdin.read().split())
ans = []

for i in itertools.permutations([x for x in range(1, n + 1)], m):
    ans.append(" ".join(map(str, i)))
sys.stdout.write("\n".join(ans))


