import sys
n, s = sys.stdin.read().rstrip().split("\n")
n = int(n)
sys.stdout.write("A" if (tmp := n - s.count('B')) > (n >> 1) else "B" if n - tmp > (n >> 1) else "Tie")