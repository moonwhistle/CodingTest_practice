import sys

N = int(sys.stdin.readline())

dic = {}
for i in range(N):
    name, what = map(str, sys.stdin.readline().split())

    dic[name] = what

ll = []
for k, v in dic.items():
    if v == "enter":
        ll.append(k)

ll.sort()
ll.reverse()

for i in ll:
    print(i)
