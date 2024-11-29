import sys, itertools
def get_cnt(s):
    cnt = 0
    for i in range(1, len(s)):
        if s[i - 1] != s[i]:
            cnt +=1
    return cnt
n, *lst = sys.stdin.read().rstrip().split("\n")
lst = list(map(lambda x : [x, get_cnt(x)], lst))

ans = 1 << 20
for p in itertools.permutations(lst):
    cnt = 0
    prev = -1
    for item in p:
        cnt += item[1]
        if item[0][0] != prev:
            cnt += 1
        prev = item[0][-1]            
    ans = min(ans, cnt - 1)        
sys.stdout.write(str(ans))         