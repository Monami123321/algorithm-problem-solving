import sys
s = sys.stdin.read().rstrip()
ans = 10
for i in range(1, len(s)):
    if s[i - 1] == s[i]:
        ans += 5
    else:
        ans += 10
sys.stdout.write(str(ans))        