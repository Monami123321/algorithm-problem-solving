import sys
n, *lst = sys.stdin.read().split()
sys.stdout.write("\n".join(sorted(map(lambda x : x[::-1].lstrip("0"), lst), key = int)))