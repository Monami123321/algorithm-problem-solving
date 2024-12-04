import sys, functools
ans = [0] * 10 
for i in str(functools.reduce(lambda a, b: a * b, map(int, sys.stdin.read().split()), 1)):
    ans[int(i)] += 1             
sys.stdout.write("\n".join(map(str, ans)))             