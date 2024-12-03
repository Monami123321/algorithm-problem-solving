import sys
visited = [False] * 21
n = int(sys.stdin.readline())
for i in range(n):
    line = sys.stdin.readline()
    lst = line.split()
    cmd = lst[0]
    if cmd == "add":
        visited[int(lst[1])] = True
    elif cmd == "remove":
        visited[int(lst[1])] = False
    elif cmd == "check":
        index = int(lst[1])
        if(visited[index]):
            sys.stdout.write("1\n")
        else:
            sys.stdout.write("0\n")
    elif cmd == "toggle":
        index = int(lst[1])
        visited[index] = not visited[index]
    elif cmd == "all":
        visited = [True] * 21
    else:
        visited = [False] * 21                         