import sys
a, b = sys.stdin.read().split()
sys.stdout.write(f"{int(a.replace('6','5')) + int(b.replace('6','5'))} {int(a.replace('5', '6')) + int(b.replace('5', '6'))}")