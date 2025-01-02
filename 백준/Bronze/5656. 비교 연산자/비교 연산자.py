import sys
ans = []
list = list(sys.stdin.read().rstrip().split("\n"))
list.pop()
for i, line in enumerate(list, 1):
    if eval(line):
        ans.append(f"Case {i}: true")
    else:
        ans.append(f"Case {i}: false")     
sys.stdout.write("\n".join(ans))        