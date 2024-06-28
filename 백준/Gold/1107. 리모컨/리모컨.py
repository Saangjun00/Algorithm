import sys

input = sys.stdin.readline

N = int(input().strip())    # 이동하려는 채널
M = int(input().strip())    # 고장난 버튼의 수

broken = list(map(int, input().split()))    # 고장난 버튼

# 현재 채널에서 +, -만으로 이동하려는 경우
min_count = abs(100 - N)

# 이동하려는 채널은 500000
# 작은 수에서 큰 수로 이동할 때 500000이지만 반대일 경우도 생각
for i in range(1000001):
    num = str(i)
    for j in range(len(num)):
        # 각 숫자가 고장났는지 확인
        if int(num[j]) in broken:
            break

        # 고장난 숫자가 없이 끝까지 도달했으면
        elif j == len(num) - 1:
            min_count = min(min_count, abs(int(num) - N) + len(num))

print(min_count)



