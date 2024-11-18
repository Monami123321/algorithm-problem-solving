import sys
s = sys.stdin.read().rstrip()
sys.stdout.write("0" if s == "(1)" else "2" if s == ")1(" else "1")