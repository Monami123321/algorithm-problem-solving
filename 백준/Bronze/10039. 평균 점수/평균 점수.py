import sys
sys.stdout.write(str(sum([max(40, x) for x in map(int, sys.stdin.read().rstrip().split()) ])//5))