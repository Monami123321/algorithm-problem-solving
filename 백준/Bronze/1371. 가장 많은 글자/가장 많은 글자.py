import sys

arr = [0] * 128

for line in sys.stdin:
    for l in line:
        if l == " " or l == "\n":
            continue
        arr[ord(l)] += 1
ans = ""
max_cnt = 0
for index, val in enumerate(arr):
    if val > max_cnt:
        ans = chr(index)
        max_cnt = val
    elif val == max_cnt:
        ans += chr(index)
    
print(ans)
    




