import sys
n, *lst = map(int, sys.stdin.read().split())
s = set()
lst_sum = sum(lst)
for i in lst:
    s.add(lst_sum - i)
    
sys.stdout.write(str(len(s)) +"\n" + " ".join(map(str, sorted(s))))    