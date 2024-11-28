import sys
tc = int(sys.stdin.readline())
ans=[]
for i in range(1, tc + 1):
    ans.append(f"Case #{i}: {' '.join(map(str,reversed(sys.stdin.readline().rstrip().split())))}")
sys.stdout.write("\n".join(ans))    