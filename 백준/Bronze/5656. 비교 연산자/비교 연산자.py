import sys
ans = []
for i, line in enumerate(sys.stdin.read().rstrip().split("\n")[:-1], 1):
    if eval(line):
        ans.append(f"Case {i}: true")
    else:
        ans.append(f"Case {i}: false")     
sys.stdout.write("\n".join(ans))        