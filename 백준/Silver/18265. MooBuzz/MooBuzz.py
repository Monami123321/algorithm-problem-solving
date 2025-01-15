import sys
n = int(sys.stdin.read())
m = n // 3 + n // 5 - n // 15
n += m
while(True):
    next_m = n // 3 + n // 5 - n // 15 - m
    if not next_m:
        break
    n += next_m
    m += next_m
sys.stdout.write(str(n))