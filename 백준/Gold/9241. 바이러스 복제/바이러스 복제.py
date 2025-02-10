import sys

a, b = sys.stdin.read().rstrip().split("\n")
left = 0
l = len(a)
ll = len(b)
right = ll - 1
while left < l and left < ll:
    if a[left] != b[left]:
        break
    left += 1
l -= 1    
while right >= left and l >= left:    
    if a[l] != b[right]:
        break
    right -= 1
    l -= 1
sys.stdout.write(str(max(0, right - left + 1)))        