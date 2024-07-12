import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

result = []

def backtracking(start):
    if len(result) == M:
        print(*result)
        return
    
    for i in range(start, N):
        if arr[i] not in result:
            result.append(arr[i])
            backtracking(i)
            result.pop()

backtracking(0)