h = m = 0
for i in map(int, input().split(":")):
    if 0 < i and i < 13:
        h += 1
    elif i < 60:
        m += 1
if h == 3:
    print(6)
elif h == 2 and m == 1:
    print(4)
elif h == 1 and m == 2:
    print(2)
else:
    print(0)