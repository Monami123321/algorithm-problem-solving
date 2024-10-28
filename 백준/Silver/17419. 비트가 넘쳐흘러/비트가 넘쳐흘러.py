import sys
a, b = sys.stdin.read().rstrip().split("\n")
cnt = 0
for i in b:
    if i == "1":
        cnt += 1
sys.stdout.write(str(cnt))