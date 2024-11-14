import sys
n = int(sys.stdin.read())
sys.stdout.write(str("".join([str(i) for i in range(1, n+1)]).find(str(n)) + 1))
