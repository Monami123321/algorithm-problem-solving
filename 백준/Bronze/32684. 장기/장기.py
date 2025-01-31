import sys
ref = [13, 7, 5, 3, 3, 2]
s1 = 0
s2 = 1.5
for i, v in enumerate(map(int, sys.stdin.readline().split())):
    s1 += ref[i] * v
for i, v in enumerate(map(int, sys.stdin.readline().split())):
    s2 += ref[i] * v    
sys.stdout.write("cocjr0208" if s1 > s2 else "ekwoo")    
    
