import sys
tc, *line = sys.stdin.read().rstrip().split("\n")
ans = []
for l in line:
    a, b = l.split()
    arr = []
    for i in range(len(a)):
        val = ord(b[i]) - ord(a[i])
        arr.append(str(val if val >= 0 else val + 26))
    ans.append(f"Distances: {' '.join(arr)}")            
sys.stdout.write("\n".join(ans))   