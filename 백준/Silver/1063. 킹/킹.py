import sys

def to_int(char):
    return(ord(char) - 64)

def to_char(n):
    return(chr(n + 64))

def is_valid(pos):
    return (1 <= pos[0] <= 8) and (1 <= pos[1] <= 8)
    
a, b, n = sys.stdin.readline().split()
king = [int(a[1]), to_int(a[0])]
stone = [int(b[1]), to_int(b[0])]
ref = {'T':0,'RT':1,'R':2,'RB':3,'B':4,'LB':5,'L':6,'LT':7}
dr = [1,1,0,-1,-1,-1,0,1]
dc = [0,1,1,1,0,-1,-1,-1]
for i in map(lambda x: ref[x], sys.stdin.read().rstrip().split()):
    if(not is_valid(tmp1 := [king[0] + dr[i], king[1] + dc[i]])):
        continue
    if(tmp1[0] == stone[0] and tmp1[1] == stone[1]):
        if(is_valid(tmp2 := [stone[0] + dr[i], stone[1] + dc[i]])):
            king = tmp1
            stone = tmp2
        else:
            continue
    else:
        king = tmp1
sys.stdout.write(f"{to_char(king[1]) + str(king[0])}\n{to_char(stone[1]) + str(stone[0])}")  