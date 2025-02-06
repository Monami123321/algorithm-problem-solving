import sys

def camel_to_snake(s):
    w = ""
    index = 0
    for i, v in enumerate(s):
        if v.isupper():
            w += s[index:i] + "_" + v.lower()
            index = i + 1
    return w + s[index:]

def snake_to_camel(s):
    index = 0
    w = ""
    for i, v in enumerate(s):
        if v == "_":
            w += s[index:i] + s[i + 1].upper()
            index = i + 2
    return w + s[index:]

n, s = sys.stdin.read().rstrip().split()
n = int(n)
c = None
p = None
sn = None
if n == 1:
    c = s
    p = s[0].upper() + s[1:]
    sn = camel_to_snake(s)
elif n == 2:
    c = snake_to_camel(s)
    p = c[0].upper() + c[1:]
    sn = s
else:
    c = s[0].lower() + s[1:]
    p = s
    sn = camel_to_snake(c)
sys.stdout.write(f"{c}\n{sn}\n{p}")    