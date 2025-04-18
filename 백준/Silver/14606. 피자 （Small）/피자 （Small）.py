n = int(input())

def recur(n):
    if n < 2:
        return 0
    if n == 2:
        return 1
    if n == 3:
        return 3
    if (n & 1) == 0:
        return (n >> 1)**2 + recur(n >> 1) * 2
    return (n >> 1) * ((n >> 1) + 1) + recur(n >> 1)  + recur((n >> 1) + 1)
print(recur(n))