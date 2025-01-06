import sys , bisect
lst = [x * x for x in range(1, 11)]
ans = []
tc, *line = sys.stdin.read().rstrip().split("\n")
for i in map(int, line):
    index = bisect.bisect_left(lst, i)
    if index > 10 or i < lst[index]:
        ans.append(str(index))
    else:
        ans.append(str(index+1))
sys.stdout.write("\n".join(ans))   