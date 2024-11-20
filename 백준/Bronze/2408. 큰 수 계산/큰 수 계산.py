import sys
n, *arr = sys.stdin.read().rstrip().split("\n")
sys.stdout.write(str(eval("".join(["//" if x == "/" else x for x in arr]))))