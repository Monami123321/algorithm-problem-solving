import sys

dic = {"Mon" : 0, "Tue" : 24, "Wed" : 48, "Thu" : 72, "Fri" : 96}
t, n = map(int, sys.stdin.readline().split())
t_sum = 0
for i in range(n):
    a, b, c, d = sys.stdin.readline().split()
    t_sum += dic[c] + int(d) - dic[a] - int(b)
    
sys.stdout.write(str(0 if (tmp := t - t_sum) < 0 else -1 if tmp > 48 else tmp))     
    
    
