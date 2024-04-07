import math

h, w, n, m = map(int, input().split())

# (강의실 길이) / (간격 + 1)을 올림한 값과 동일
a = math.ceil(w / (m + 1))
b = math.ceil(h / (n + 1))

print(a * b)