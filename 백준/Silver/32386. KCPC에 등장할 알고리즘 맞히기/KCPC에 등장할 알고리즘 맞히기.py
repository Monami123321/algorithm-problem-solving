import sys
n, *lst = sys.stdin.read().rstrip().split("\n")

dict = {}

for line in lst:
    for i in line.rstrip().split(" ")[2:]:
        dict[i] = dict.get(i, 0) + 1

m = 0
ans = None
for k, v in dict.items():
    if v > m:
        m = v
        ans = k
for k, v in dict.items():
    if v == m and k != ans:
        sys.stdout.write("-1")
        exit()
sys.stdout.write(ans)                         