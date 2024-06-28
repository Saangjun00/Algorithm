import sys

input = sys.stdin.readline

def find_year(m, n, x, y):
    k = x
    while k <= m * n:
        if (k - x) % m == 0 and (k - y) % n == 0:
            return k
        k += m
    return -1

t = int(input().strip())

for _ in range(t):
    m, n, x, y = map(int, input().split())

    print(find_year(m, n, x, y))