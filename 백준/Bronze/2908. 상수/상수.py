import sys
sys.stdout.write(str(max(map(lambda x : int(x[::-1]), sys.stdin.read().split(" ")))))
