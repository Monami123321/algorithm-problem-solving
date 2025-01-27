import sys

n, *lst = map(int, sys.stdin.read().rstrip().split("\n"))
sys.stdout.write("Junhee is not cute!" if n // 2 < len(list(filter(lambda x: x == 0, lst))) else "Junhee is cute!")