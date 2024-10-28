import sys
tc = sys.stdin.readline()
ans = []
for line in sys.stdin.read().rstrip().split("\n"):
    m = 1 << 30
    s = 0
    for i in list(map(int, line.split(" "))):
        if i & 1 == 0:
            s += i
            if i < m:
                m = i
    ans.append(f"{s} {m}")
sys.stdout.write("\n".join(ans))            
        