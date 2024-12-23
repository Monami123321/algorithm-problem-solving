import sys
s = sys.stdin.read().rstrip()
last = s[-1]
major = {"C","F","G"}
minor = {"A","D","E"}
cnt_mj = 0
cnt_mn = 0
for i in map(lambda x: x[0], s.split("|")):
    if i in major:
        cnt_mj += 1
    elif i in minor:
        cnt_mn += 1
ans = None
if cnt_mj > cnt_mn:
    ans = "C-major"
elif cnt_mn > cnt_mj:
    ans = "A-minor"
else:
    if last in major:
        ans = "C-major"
    else:
        ans = "A-minor"
sys.stdout.write(ans)