import sys
tc, *arr = sys.stdin.read().rstrip().split("\n")
ans = []
tc = int(tc)
for i in range(0, tc << 1, 2):
    ans.append(arr[i].translate(str.maketrans("ABCDEFGHIJKLMNOPQRSTUVWXYZ", arr[i + 1].rstrip())))
sys.stdout.write("\n".join(ans))    