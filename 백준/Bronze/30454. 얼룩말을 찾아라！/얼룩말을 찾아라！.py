import sys

def cal_cnt(s):
    cnt = 0 if s[0] == "0" else 1
    for i in range(1, len(s)):
        if s[i] == "1" and s[i - 1] == "0":
            cnt += 1
    return cnt       
        
n, l = map(int, sys.stdin.readline().split())
cnt = 0
m = 0
for i in range(n):
    if (tmp := cal_cnt(sys.stdin.readline())) > m:
        cnt = 1
        m = tmp
    elif m == tmp:        
        cnt +=1
sys.stdout.write(f"{m} {cnt}")    