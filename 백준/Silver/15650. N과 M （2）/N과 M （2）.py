import sys

input = sys.stdin.readline

N, M = map(int, input().split())
result = []

# 중복을 제거하기 위해 start 변수 사용
def backtracking(start):
    if len(result) == M:
        print(*result)
        return
    
    for i in range(start, N + 1):
        if i not in result:
            result.append(i)
            backtracking(i + 1)
            result.pop()
            
backtracking(1)
