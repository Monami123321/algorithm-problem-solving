input()
a = b = 0
for i in input().split():
    a += int(i)
for i in input().split():
    b += int(i)
print(a - b)