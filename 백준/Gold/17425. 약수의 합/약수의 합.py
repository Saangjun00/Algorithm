import sys

input = sys.stdin.readline

# 최대값
MAX = 1000000

# 약수의 합을 담아 놓을 배열
dp = [0] * (MAX + 1)

# 누적 합 담을 배열
s = [0] * (MAX + 1)

for i in range(1, MAX + 1):
    j = 1
    # i를 약수로 가지는 수들에 i를 더해줌
    while i * j <= MAX:
        dp[i * j] += i
        j += 1
    
    s[i] = s[i - 1] + dp[i]

t = int(input().strip())

for _ in range(t):
    n = int(input().strip())
    print(s[n])