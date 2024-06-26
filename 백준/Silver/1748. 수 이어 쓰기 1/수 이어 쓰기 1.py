# 한자리 숫자
# 10**((숫자의 자릿수)-1) * (숫자의 자릿수)
# 1~9까지 이어붙인 숫자의 자릿수 9*10**(1-1) * 1 = 9

# 공식
# 숫자의 자릿수 = n
# 9 * (10**n) * (n+1)

import sys

input = sys.stdin.readline

N = input().strip()
length = len(N) - 1
result = 0

for i in range(length):
    result += 9 * (10 ** i) * (i + 1)

result += ((int(N) - (10**length)) + 1) * len(N)

print(result)