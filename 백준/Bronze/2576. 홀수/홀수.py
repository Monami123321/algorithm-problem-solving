arr = [];
sum = 0;
for i in range(7):
    n = int(input());
    if (n & 1) == 0:
        continue;
    sum += n;
    arr.append(n);
if len(arr) == 0:
    print(-1);
else:
    arr.sort();
    print(f"{sum}\n{arr[0]}");
    


    
