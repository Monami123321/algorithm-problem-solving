from sys import stdin, stdout

n, *lst = stdin.read().rstrip().split("\n")
dict = {}
for l in lst:
    a, b = l.split(" ")
    dict[a] = dict.get(a, 0) + int(b)

for v in dict.values():
    if v == 5:
        stdout.write("YES")
        exit()
        
stdout.write("NO")