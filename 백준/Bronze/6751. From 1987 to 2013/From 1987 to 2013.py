import sys

n = int(sys.stdin.read()) + 1
while True:
    if len(set(str(n))) == len(str(n)):
           sys.stdout.write(str(n))
           break
    else:
           n += 1