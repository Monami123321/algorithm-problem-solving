import sys
lst = list(map(int, sys.stdin.read().rstrip().split("\n")))
dic = {}
for i in lst:
    dic[i] = dic.get(i, 0) + 1
    
val = 0
index= 0
for k, v in dic.items():
    if val < v:
        val = v
        index = k
sys.stdout.write(f"{sum(lst) // 10}\n{index}")

