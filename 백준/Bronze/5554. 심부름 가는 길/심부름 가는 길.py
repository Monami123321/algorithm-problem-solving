import sys
n = sum(map(int, sys.stdin.read().rstrip().split("\n")))
sys.stdout.write(f"{n // 60}\n{ n % 60}")