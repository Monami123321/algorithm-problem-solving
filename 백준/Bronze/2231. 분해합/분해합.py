def get_val(n):
    val = n
    while n > 0:
        val += n % 10
        n //= 10
    return val

target = int(input())
ans = 0
for i in range(1, target + 1000):
    if get_val(i) == target:
        ans = i
        break
print(ans)
