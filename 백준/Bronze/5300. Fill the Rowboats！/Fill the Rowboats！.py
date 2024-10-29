n = int(input())
idx = 1
ans=[]
while idx <= n:
    ans.append(str(idx))
    if idx % 6 ==0:
        ans.append("Go!")
    idx += 1
if n % 6 !=0:
    ans.append("Go!")
print(" ".join(ans))