import sys
tc = int(sys.stdin.readline())
ans = []
for i in range(tc):
    n, *arr = map(int, sys.stdin.readline().split())
    avg = sum(arr) / n
    ans.append(f"{len([x for x in arr if x > avg]) / n * 100:.2f}%") 
sys.stdout.write("\n".join(ans))    