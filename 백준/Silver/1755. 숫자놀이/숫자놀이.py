import sys, functools

dic = {"1":"one","2":"two","3":"three","4":"four","5":"five","6":"six","7":"seven","8":"eight","9":"nine","0":"zero"}
def compare(a, b):
    a = "".join([dic[x] for x in a])
    b = "".join([dic[x] for x in b])
    return -1 if a < b else 0 if a == b else 1
s, e = map(int, sys.stdin.read().rstrip().split())
lst = sorted([str(x) for x in range(s, e+1)], key=functools.cmp_to_key(compare))
sys.stdout.write("\n".join([" ".join(lst[i:i+10]) for i in range(0, len(lst), 10)]))