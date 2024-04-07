n = int(input())
num = list(map(int, input().split()))

num.sort()

if n == 1:
    print(num[0] * num[0])
else:
    print(num[0] * num[-1])