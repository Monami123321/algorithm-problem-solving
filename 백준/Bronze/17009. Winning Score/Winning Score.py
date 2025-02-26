import sys
a,b,c,d,e,f = map(int, sys.stdin.read().rstrip().split("\n"))
sys.stdout.write("A" if (tmp1 := a * 3 + b * 2 + c) > (tmp2 := d * 3 + e * 2 + f) else "T" if tmp1 == tmp2 else "B")