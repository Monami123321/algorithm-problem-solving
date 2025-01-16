import sys, functools
lst = [0] * 10
n = functools.reduce(lambda a, b: a * b, map(int, sys.stdin.read().rstrip().split("\n")))
while n:
    lst[n % 10] += 1
    n //= 10
sys.stdout.write("\n".join(map(str, lst)))    