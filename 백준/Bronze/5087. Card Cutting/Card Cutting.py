import sys
cnt = [0, 0]
ans = []
for line in sys.stdin.read().rstrip("#\n").split("\n"):
    for i in map(lambda x: 1 if x == 'A' else int(x), line.split()[:-1]):
        cnt[(i & 1)] += 1
    ans.append("Cheryl" if cnt[1] > cnt[0] else "Draw" if cnt[0] == cnt[1] else "Tania")            
    cnt = [0, 0]
sys.stdout.write("\n".join(ans))    