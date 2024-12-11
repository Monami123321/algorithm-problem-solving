import sys
ans = []
for line in sys.stdin.read().rstrip().split("\n"):
    is_even = (len(list(filter(lambda x: x=="1", line[:-1]))) & 1) == 0
    last_digit = line[-1]
    tmp = None
    if (last_digit == 'e' and is_even) or (last_digit == 'o' and not is_even):
        tmp = "0"
    else:
        tmp = "1"
    ans.append(line[:-1] + tmp)        
ans.pop()    
sys.stdout.write("\n".join(ans))    
    
    