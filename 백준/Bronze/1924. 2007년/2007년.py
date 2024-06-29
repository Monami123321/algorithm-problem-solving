m, d = map(int, input().split());
month = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
for i in range(1, 12):
    month[i] += month[i - 1];
ref = month[m - 1] + d;
day = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"];
print(day[(ref % 7) -1]);



