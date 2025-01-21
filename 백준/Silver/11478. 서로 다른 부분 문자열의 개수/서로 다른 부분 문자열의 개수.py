import sys

word = sys.stdin.read().rstrip()
s = set(word)
for i in range(2, len(word) + 1):
    for j in range(len(word) + 1 - i):
        s.add(word[j:j+i])
sys.stdout.write(str(len(s)))        
        
