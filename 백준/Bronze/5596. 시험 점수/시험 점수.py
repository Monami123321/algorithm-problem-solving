import sys
a, b = sys.stdin.read().rstrip().split("\n")
sys.stdout.write(str(max(sum(map(int, a.split(" "))), sum(map(int, b.split(" "))))))

