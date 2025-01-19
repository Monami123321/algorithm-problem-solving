import sys

m = int(sys.stdin.read())
start = 1
end = m * 5
while start <= end:
    mid = start + end >> 1
    cnt = 0
    tmp = mid
    while tmp:
        tmp //= 5
        cnt += tmp
    if cnt >= m:
        end = mid - 1
    else:
        start = mid + 1
cnt = 0
tmp = start
while tmp:
    tmp //= 5
    cnt += tmp
sys.stdout.write("-1" if m != cnt else str(start))    

        
        
