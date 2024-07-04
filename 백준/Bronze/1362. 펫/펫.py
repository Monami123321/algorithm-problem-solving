from sys import stdin, exit

index = 1
lst = []
while True:
    l, w = map(int, stdin.readline().rstrip().split())
    if l == 0:
        break
    low = l >> 1
    high = l << 1
    flag = False
    while True:
        cmd, val = stdin.readline().rstrip().split()
        if cmd == '#':
            if flag:
                lst.append(f"{index} RIP")
            elif low < w and w < high:
                lst.append(f"{index} :-)")
            else:
                lst.append(f"{index} :-(")
            index += 1
            break
        elif cmd == 'F':
            w += int(val)
        else:
            w -= int(val)
            
        if w <=0:
            flag = True
         
print("\n".join(lst))