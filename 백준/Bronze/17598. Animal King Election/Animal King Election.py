import sys
sys.stdout.write("Lion" if len(list(filter(lambda x: x =="Lion", sys.stdin.read().rstrip().split()))) > 4 else "Tiger")