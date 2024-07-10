def to_int(time):
    arr = time.split(":")
    return int(arr[0]) * 3600 + int(arr[1]) * 60 + int(arr[2])

def to_str(time):
    hour = time // 3600
    time -= hour * 3600
    minute = time // 60
    time -= minute * 60
    second = time
    if(hour < 10):
        hour = "0" + str(hour)
    else:
        hour = str(hour)
    if(minute < 10):
        minute = "0" + str(minute)
    else:
        minute = str(minute)
    if(second < 10):
        second = "0" + str(second)
    else:
        second = str(second)
    return hour + ":" + minute + ":" + second

now = to_int(input())
start = to_int(input())
if(now <= start):
    print(to_str(start - now))
else:
    print(to_str(3600 * 24 - now + start))




    