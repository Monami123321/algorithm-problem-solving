import sys
lst = list(map(int, sys.stdin.read().rstrip().split("\n")))
m = sum(lst)
for i in range(8):
    flag = False
    for j in range(i + 1, 9):
        if m - (lst[i] + lst[j]) == 100:
            del lst[j]
            del lst[i]
            flag = True
            break
    if flag:
        break            
sys.stdout.write("\n".join(map(str, lst)))            