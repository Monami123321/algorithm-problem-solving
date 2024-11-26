import sys
a,b,c = map(int, sys.stdin.read().rstrip().split("\n"))
ans = ""
if a+b+c != 180:
    ans = "Error"
elif a == b and b == c:
    ans = "Equilateral"
elif a == b or b == c or c == a:
    ans = "Isosceles"
else:
    ans = "Scalene"
sys.stdout.write(ans)    
    
    