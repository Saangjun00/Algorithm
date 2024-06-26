arr = []
for i in range(9):
    a = int(input())
    arr.append(a)

arr.sort()

sum100 = sum(arr)

for i in range(len(arr)):
    for j in range(i+1, len(arr)):
        if sum100 - (arr[i] + arr[j]) == 100:
            temp1 = arr[i]
            temp2 = arr[j]

arr.remove(temp1)
arr.remove(temp2)

for i in arr:
    print(i)