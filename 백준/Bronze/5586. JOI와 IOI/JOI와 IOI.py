import sys
a = sys.stdin.read().rstrip()
cnt1 = 0
cnt2 = 0
for i in range(len(a) - 2):
    if a[i:i+3] == 'JOI':
        cnt1 += 1
    elif a[i:i+3] == 'IOI':
        cnt2 += 1
sys.stdout.write(f"{cnt1}\n{cnt2}")        

