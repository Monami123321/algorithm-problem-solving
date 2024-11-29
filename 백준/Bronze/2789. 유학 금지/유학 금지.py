import sys
sys.stdout.write(sys.stdin.read().rstrip().translate(str.maketrans("","","CAMBRIDGE")))