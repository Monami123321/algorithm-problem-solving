import sys
n, *lst = sys.stdin.read().rstrip().split("\n")
index = 0
ans = 0
for i, v in enumerate(lst):
    if v == "ENTER":
        ans += len(set(lst[index + 1: i]))
        index = i
ans += len(set(lst[index + 1:]))        
sys.stdout.write(str(ans))                 