import sys

ans = []
vowel = {"a", "e", "i", "o", "u"}
for line in sys.stdin.read().rstrip("\n#").split("\n"):
    flag = True
    for i in range(len(line)):
        if line[i] in vowel:
            flag = False
            ans.append(line[i:] + line[:i] + "ay")
            break
    if flag:
        ans.append(line + "ay")
sys.stdout.write("\n".join(ans))            