import sys
n, k, *lst = map(int, sys.stdin.read().split())
cnt = 0
for i in range(n - 1, 0, -1):
    index = i
    v = lst[index]
    for j in range(0, i):
        if lst[j] > v:
            index = j
            v = lst[j]
    if lst[i] != v:
        cnt += 1
        lst[i], lst[index] = lst[index], lst[i]
    if cnt == k:
        sys.stdout.write((f"{lst[index]} {lst[i]}"))
        exit()
sys.stdout.write("-1")        