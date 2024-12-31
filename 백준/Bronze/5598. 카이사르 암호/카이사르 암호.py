import sys
ans = []
for i in sys.stdin.read().rstrip():
    ans.append(chr((ord(i) - 42) % 26 + 65))
sys.stdout.write("".join(ans))    