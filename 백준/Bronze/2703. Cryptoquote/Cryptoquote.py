import sys
input = sys.stdin.readline
tc = int(input())
ans = []
while tc:
    tc -= 1
    arr = list(input().rstrip())
    ref = list(input().rstrip())
    for i in range(len(arr)):
        if arr[i] == " ":
            continue
        arr[i] = ref[ord(arr[i]) - 65]
    ans.append("".join(arr))        
sys.stdout.write("\n".join(ans))        
                            
    