import sys
lst = sys.stdin.read().rstrip().split()
s = {'i', 'pa', 'te', 'ni', 'niti', 'a', 'ali', 'nego', 'no', 'ili'}
ans = [lst[0][0].upper()]
for i in range(1, len(lst)):
    if lst[i] not in s:
        ans.append(lst[i][0].upper())
sys.stdout.write("".join(ans))    