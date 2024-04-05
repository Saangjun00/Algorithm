while True:
    n = int(input())
    num = []

    if n == -1:
        break

    for i in range(1, n):
        if n % i == 0:
            num.append(i)

    if sum(num) == n:
        print(n, " = ", ' + '.join(map(str, num)), sep = '')
    else:
        print(n, "is NOT perfect.")