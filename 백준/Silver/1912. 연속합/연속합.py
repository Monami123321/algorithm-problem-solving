import sys

n, *lst = map(int, sys.stdin.read().split())
local_max = global_max = -1234567890
for i in lst:
    local_max = max(i, local_max + i)
    global_max = max(global_max, local_max)
sys.stdout.write(str(global_max))    




