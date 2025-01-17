import sys

n = (1 << int(sys.stdin.read())) - 1
sys.stdout.write(format(n * (n + 1) >> 1, 'b'))

