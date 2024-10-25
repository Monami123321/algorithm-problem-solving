import sys

sys.stdin.readline()
sys.stdout.write(str(len(list(filter(lambda x : (x & 1) != 0, map(int, sys.stdin.read().rstrip().split("\n")))))))