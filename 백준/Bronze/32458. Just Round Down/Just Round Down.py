import sys
s = sys.stdin.read()
sys.stdout.write(s[:s.index(".")])