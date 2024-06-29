a, b = input().split();

sum = 0;
for n in a:
    for m in b:
        sum += int(n) * int(m);
print(sum);
        