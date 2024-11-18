import sys
input = sys.stdin.readline
output = sys.stdout.write
tc = int(input())
ans = []
for i in range(tc):
    w = input().rstrip()
    n = int(input())
    cnt = -1
    word_len = len(w)
    word_ans = ""
    for j in range(n):
        tmp = input().rstrip()
        cnt_case = 0
        for k in range(word_len):
            if w[k] == tmp[k]:
                cnt_case += 1
        if cnt < cnt_case:
            cnt = cnt_case
            word_ans = tmp
    ans.append(word_ans)                
output("\n".join(ans))    
           
        
        