s = int(input())
sum  = 0
count = 0

while True:
    count += 1
    sum += count

    if sum > s:
        break

print(count - 1)