import sys
lst = list(map(int, sys.stdin.read().rstrip().split("\n")))
w = sum(sorted(lst[:10], reverse=True)[:3])
k = sum(sorted(lst[10:], reverse=True)[:3])
sys.stdout.write(f"{w} {k}")
