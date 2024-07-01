a, b, c = map(int, input().split())
if b > c:
    print('Subway')
elif b == c:
    print('Anything')
else:
    print('Bus')
