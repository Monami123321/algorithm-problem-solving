import sys
if int(sys.stdin.read()).bit_count() != 1:
    sys.stdout.write("0")
else:
    sys.stdout.write("1")
        
        