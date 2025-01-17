import sys

lst = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]
arr = []
a, b = sys.stdin.read().rstrip().split("\n")
for i in range(len(a)):
    arr.append(lst[ord(a[i]) - 65])
    arr.append(lst[ord(b[i]) - 65])
l = 0    
while (l := len(arr)) > 2:
    for i in range(l - 1):
        arr.append((arr[i] + arr[i + 1]) % 10)
    arr = arr[l:]        
sys.stdout.write("".join(map(str, arr)))    
    
    
    
