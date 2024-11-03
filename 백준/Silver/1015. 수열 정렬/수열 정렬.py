import sys, functools

def compare(a, b):
    if a[1] != b[1]:
        return a[1] - b[1]
    return a[0] - b[0]

n = int(sys.stdin.readline())
arr = [[i] for i in range(n)]

for i, e in enumerate(sys.stdin.readline().split(" ")):
    arr[i].append(int(e))
    
arr.sort(key=functools.cmp_to_key(compare))

for i in range(n):
    arr[arr[i][0]][1] = i
    
sys.stdout.write(" ".join([str(e[1]) for e in arr]))    
    
    