import sys
n = int(sys.stdin.readline())
lst_1 = list(map(int, sys.stdin.readline().split()))
lst_2 = list(map(int, sys.stdin.readline().split()))
lst_3 = list(map(lambda x: int(float(x) * 10), sys.stdin.readline().split()))

ans = 0
for i in range(n):
    if lst_3[i] < 10:
        ans += lst_1[i] - lst_2[i] * lst_3[i] // 10
    else:
        ans += lst_1[i] * lst_3[i] // 10 - lst_2[i]
sys.stdout.write(str(ans))    
    