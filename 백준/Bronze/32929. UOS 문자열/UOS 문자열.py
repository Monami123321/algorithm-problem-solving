import sys
arr = ['U','O','S']
sys.stdout.write(arr[(int(sys.stdin.read()) - 1) % 3])