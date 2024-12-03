import sys, math

def get_score(dist):
    if dist <= 3:
        return 100
    if dist <= 6:
        return 80
    if dist <= 9:
        return 60    
    if dist <= 12:
        return 40
    if dist <= 15:
        return 20
    return 0    
a, *line = sys.stdin.read().rstrip().split("\n")
ans = []
for l in line:
    lst = list(map(float, l.split()))
    p1 = 0
    p2 = 0
    
    for i in range(3):
        p2 += get_score(math.sqrt(lst.pop() ** 2 + lst.pop() ** 2))
    for i in range(3):
        p1 += get_score(math.sqrt(lst.pop() ** 2 + lst.pop() ** 2))        
    if p1 == p2:
        ans.append(f"SCORE: {p1} to {p2}, TIE.")
    else:
        ans.append(f"SCORE: {p1} to {p2}, PLAYER {1 if p1 > p2 else 2} WINS.")
sys.stdout.write("\n".join(ans))    
        