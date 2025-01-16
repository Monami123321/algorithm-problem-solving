import sys, functools
lst = [0] * 10
for i in str(functools.reduce(lambda a, b: a * b, map(int, sys.stdin.read().rstrip().split("\n")))):
    lst[int(i)] += 1
sys.stdout.write("\n".join(map(str, lst)))    