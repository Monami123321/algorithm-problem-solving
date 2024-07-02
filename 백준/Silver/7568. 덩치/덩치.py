n = int(input())
arr = []
for i in range(n):
    a, b = map(int, input().split())
    arr.append((a, b))
ans = " "
list = []
for item in arr:
    cnt = 0
    for i in arr:
        if i[0] > item[0] and i[1] > item[1]:
            cnt += 1
    list.append(str(cnt + 1))

print(ans.join(list))