import sys
sys.stdin.readline()
ans = 0
ref = [0] * 128
for i in sys.stdin.readline():
    ref[ord(i)] += 1
for l in sys.stdin:
    tmp = [0] * 128
    for i in l:
        tmp[ord(i)] += 1
    cnt1 = 0
    cnt2 = 0
    for i in range(65, 91):
        if ref[i] != tmp[i]:
            if ref[i] - tmp[i] == 1:
                cnt1 += 1
            elif ref[i] - tmp[i] == -1:
                cnt2 += 1
            else:
                cnt1 += 1000
                break
    if (cnt1 == 0 and cnt2 == 0) or(cnt1 == 1 and cnt2 == 1) or (cnt1 == 0 and cnt2 == 1) or (cnt1 == 1 and cnt2 == 0):
        ans += 1
print(ans)        