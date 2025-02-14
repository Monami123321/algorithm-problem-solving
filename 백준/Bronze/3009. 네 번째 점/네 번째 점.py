import sys
lst = [{},{}]
for l in sys.stdin:
    a, b = map(int, l.split())
    lst[0][a] = lst[0].get(a, 0) + 1
    lst[1][b] = lst[1].get(b, 0) + 1
a = [k for k, v in lst[0].items() if v == 1][0]
b = [k for k, v in lst[1].items() if v == 1][0]
sys.stdout.write(f"{a} {b}")
    