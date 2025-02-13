import sys, functools

def cmp(a, b):
    if a[1] != b[1]:
        return b[1] - a[1]
    if len(a[0]) > len(b[0]):
        return -1
    if len(a[0]) < len(b[0]):
        return 1
    return -1 if a[0] < b[0] else 1

n, m = map(int, sys.stdin.readline().split())
dic = {}
for l in sys.stdin.read().rstrip().split("\n"):
    if len(l) >= m:
        dic[l] = dic.get(l, 0) + 1
sys.stdout.write("\n".join(map(lambda x: x[0], sorted(dic.items(), key=functools.cmp_to_key(cmp)))))         