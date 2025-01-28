import sys

n, *lst = sys.stdin.read().rstrip().split()
s = set(lst)
for l in s:
    if l[::-1] in s:
        tmp = len(l)
        sys.stdout.write(f"{tmp} {l[tmp//2:tmp//2+1]}")
        exit()