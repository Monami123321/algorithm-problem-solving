import sys

a, *cnt = map(int, sys.stdin.read().split())
ans = ""
lst = ["Watermelon", "Pomegranates", "Nuts", "Nothing"]
cnt.append(-1)
for i in range(4):
    if a >= cnt[i]:
        ans = lst[i]
        break
sys.stdout.write(ans)        
    
    

