import sys

n, m = map(int, sys.stdin.read().rstrip().split(" "))

nn = n
mm = m
k = n - m
cnt_n = 0
cnt_m = 0
cnt_k = 0

while nn >= 2 or mm >= 2 or k >= 2:
    cnt_n += nn >> 1
    nn >>= 1
    cnt_m += mm >> 1
    mm >>= 1
    cnt_k += k >> 1
    k >>= 1
    
cnt_2 = max(0, cnt_n - cnt_m - cnt_k)

nn = n
mm = m
k  = n - m

cnt_n = 0
cnt_m = 0
cnt_k = 0

while nn >= 5 or mm >=5 or k >= 5:
    cnt_n += nn // 5
    nn //= 5
    cnt_m += mm // 5
    mm //= 5
    cnt_k += k // 5
    k //= 5
    
cnt_5 = max(0, cnt_n - cnt_m - cnt_k)

sys.stdout.write(str(min(cnt_2, cnt_5)))