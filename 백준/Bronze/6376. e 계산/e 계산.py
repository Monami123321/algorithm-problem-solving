import sys

fact = [0, 1, 2]
lst = [1, 2, 2.5]
for i in range(3, 10):
    fact.append(fact[i - 1] * i)
    lst.append(lst[i - 1] + 1 / fact[i])
ans = []
for i, v in enumerate(lst[0:3]):
    ans.append(f"{i} {v}\n")
for i, v in enumerate(lst[3:], 3):
    ans.append(f"{i} {v:.9f}\n")    
sys.stdout.write(f"n e\n- -----------\n{''.join(ans)}")    
    