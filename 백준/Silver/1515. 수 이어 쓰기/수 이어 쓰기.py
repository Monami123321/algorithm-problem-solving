import sys
arr = list(sys.stdin.read().rstrip())
index = 0 
size = len(arr)
n = 1
while index < size:
    for i in str(n):
        if arr[index] == i:
            index += 1
        if index == size:
            break
    n += 1
sys.stdout.write(str(n-1))    
            
    



