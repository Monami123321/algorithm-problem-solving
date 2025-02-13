import sys
n, m = map(int, sys.stdin.readline().split())
dic = {}
for l in sys.stdin.read().rstrip().split("\n"):
    if len(l) >= m:
        dic[l] = dic.get(l, 0) + 1
sys.stdout.write("\n".join(map(lambda x: x[0], sorted(dic.items(), key=lambda x: (-x[1], -len(x[0]), x[0]) ))))         