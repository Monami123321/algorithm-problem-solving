import sys

class Node:
    def __init__(self, name, id, cnt=0):
        self.name = name
        self.id = id
        self.cnt = cnt
        
n = int(sys.stdin.readline())
cnt_ans = 0
lst = []
for i in range(n):
    name = sys.stdin.readline()
    k, m = map(int, sys.stdin.readline().split())
    cnt = 0
    r = m // k
    m %= k
    while True:
        cnt += r
        m += r << 1
        if m < k:
            break
        r = m // k            
        m %= k
    lst.append(Node(name, i, cnt))
    cnt_ans += cnt
ans = sorted(lst, key=lambda x: -(x.cnt << 7) + x.id)[0]    
sys.stdout.write(f"{cnt_ans}\n{ans.name}")
        
        
    
    
    
    