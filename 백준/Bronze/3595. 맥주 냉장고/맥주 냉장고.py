import sys
n = int(sys.stdin.read())
ans = [0, 0, 0]
w = 1 << 61
for i in range(n+1, 0, -1):
    for j in range(1, i+1):
        if i * j > n:
            break
        for k in range(1, j+1):
            if i*j*k > n:
                break
            if i * j * k == n and (tmp := ((i*j + j*k + k*i) << 1)) < w:
                w = tmp
                ans[0] = i
                ans[1] = j
                ans[2] = k
                
sys.stdout.write(" ".join(map(str,ans)))            