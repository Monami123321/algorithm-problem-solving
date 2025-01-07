import sys
sys.stdout.write(str(min(map(int, sys.stdin.read().rstrip().split("\n"))) * 100 >> 1))