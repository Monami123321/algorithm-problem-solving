import sys
m, lst = sys.stdin.read().rstrip().split("\n")
m = int(m)
lst = list(map(int, lst.split()))
index, mm, cnt1 = 0, m, 0

while index < 14:
    if lst[index] <= mm:
        cnt1 += mm // lst[index]
        mm %= lst[index]
    index += 1
cnt1 = cnt1 * lst[13] + mm

index = 3
stock = 0

while index < 14:
    if lst[index - 3] < lst[index - 2] and lst[index - 2] < lst[index - 1]:
        m += stock * lst[index]
        stock = 0
    elif lst[index - 3] > lst[index - 2] and lst[index - 2] > lst[index - 1]:
        stock += m // lst[index]
        m %= lst[index]
    index += 1
m += stock * lst[13]
sys.stdout.write("BNP" if cnt1 > m else "SAMESAME" if cnt1 == m else "TIMING")