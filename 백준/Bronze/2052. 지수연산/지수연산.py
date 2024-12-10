import sys
n = int(sys.stdin.read())
val = 5 ** n
l = len(str(val))
sys.stdout.write(f"0.{'0' * (n - l)}{val}")